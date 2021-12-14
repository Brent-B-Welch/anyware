package org.corpname.anymall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.to.*;
import org.corpname.anymall.common.to.constant.StatusConstant;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.product.dao.OrderDao;
import org.corpname.anymall.product.entity.OrderEntity;
import org.corpname.anymall.product.entity.OrderItemEntity;
import org.corpname.anymall.product.feign.WareFeignService;
import org.corpname.anymall.product.service.OrderItemService;
import org.corpname.anymall.product.service.OrderService;
import org.corpname.anymall.product.service.ProductService;
import org.corpname.anymall.product.vo.OrderInDetailVo;
import org.corpname.anymall.product.vo.OrderItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service("wareOrderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WareFeignService wareFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void createOrder(List<OrderItemCreationVo> orderVos) {
        OrderEntity orderEntity = OrderEntity.builder()
                .orderSn(UUID.randomUUID().toString())
                .orderStatus(StatusConstant.INIT)
                .originated(new Date())
                .build();
        this.save(orderEntity);

        List<OrderItemEntity> collect = orderVos.stream()
                .map(item -> {
                    OrderItemEntity orderItemEntity = OrderItemEntity.builder()
                            .orderId(orderEntity.getId())
                            .orderSn(orderEntity.getOrderSn())
                            .productId(item.getProductId())
                            .quantity(item.getQuantity())
                            .orderItemStatus(StatusConstant.INIT)
                            .build();
                    return orderItemEntity;
                }).collect(Collectors.toList());

        orderItemService.saveBatch(collect);

    }

    @Override
    public OrderInDetailVo getOrderInDetail(Long id) {
        OrderEntity orderEntity = this.getById(id);
        OrderInDetailVo orderInDetailVo = new OrderInDetailVo();
        BeanUtils.copyProperties(orderEntity, orderInDetailVo);

        List<OrderItemEntity> orderItemEntities = orderItemService.list(new QueryWrapper<OrderItemEntity>().eq("order_id", id));
        List<OrderItemVo> collect = orderItemEntities.stream()
                .map(item -> {
                    OrderItemVo orderItemVo = new OrderItemVo();
                    BeanUtils.copyProperties(item, orderItemVo);
                    return orderItemVo;
                })
                .collect(Collectors.toList());
        orderInDetailVo.setItemVos(collect);
        return orderInDetailVo;
    }

    /**
     * @MethodName: lockArticleStockByOrder
     * @Description: the method is used to lock the stock of the articles for each product
     * @Param: [id]
     * @Return: org.corpname.anymall.common.to.WareOrderVo
     * @Author: Beiji Ma
     * @Date: 2021-12-14 22:38
     */
    @Override
    public WareOrderVo lockArticleStockByOrder(Long id) {
        Date now = new Date();
        OrderEntity orderEntity = this.getById(id);

        WareOrderVo wareOrderVo = new WareOrderVo();
        // copy order information
        BeanUtils.copyProperties(orderEntity, wareOrderVo);
        wareOrderVo.setOriginated(now);
        wareOrderVo.setModified(now);
        wareOrderVo.setTaskStatus(StatusConstant.INIT);
        wareOrderVo.setTaskComment("say something, god.");

        List<OrderItemEntity> orderItemEntities = orderItemService.list(new QueryWrapper<OrderItemEntity>().eq("order_id", orderEntity.getId()));
        // process each product in the order
        List<WareOrderProductVo> collect = orderItemEntities.stream()
                .map(item -> {
                    // Copy product information
                    WareOrderProductVo wareOrderProductVo = new WareOrderProductVo();
                    BeanUtils.copyProperties(item, wareOrderProductVo);
                    wareOrderProductVo.setModified(now);
                    wareOrderProductVo.setOriginated(now);
                    wareOrderProductVo.setTaskItemStatus(StatusConstant.INIT);
                    // get article information
                    ProductWithArticlesVo productWithArticlesVo = productService.getProductWithArticlesByProductId(item.getProductId());
                    List<WareOrderProductArticleVo> articleVos = productWithArticlesVo.getProductArticleRelations()
                            .stream()
                            .map(articleItem -> {
                                WareOrderProductArticleVo wareOrderProductArticleVo = new WareOrderProductArticleVo();
                                BeanUtils.copyProperties(articleItem, wareOrderProductArticleVo);
                                wareOrderProductArticleVo.setModified(now);
                                wareOrderProductArticleVo.setOriginated(now);
                                wareOrderProductArticleVo.setStatus(StatusConstant.INIT);
                                return wareOrderProductArticleVo;
                            })
                            .collect(Collectors.toList());
                    wareOrderProductVo.setArticles(articleVos);
                    return wareOrderProductVo;
                })
                .collect(Collectors.toList());

        wareOrderVo.setProducts(collect);
        log.info("##################\n\n\n{}", wareOrderVo);

        R r = wareFeignService.lockArticleStockByOrder(wareOrderVo);
        if (r.getCode() == 0) {
            log.info("succeeded to call wareFeignService.lockArticleStockByOrder##");
        }
        return wareOrderVo;
    }
}
