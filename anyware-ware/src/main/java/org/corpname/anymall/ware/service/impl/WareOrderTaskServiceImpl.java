package org.corpname.anymall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.to.WareOrderVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.ware.dao.WareOrderTaskDao;
import org.corpname.anymall.ware.entity.WareOrderTaskEntity;
import org.corpname.anymall.ware.entity.WareOrderTaskItemEntity;
import org.corpname.anymall.ware.service.WareOrderTaskItemService;
import org.corpname.anymall.ware.service.WareOrderTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service("wareOrderTaskService")
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskDao, WareOrderTaskEntity> implements WareOrderTaskService {
    @Autowired
    WareOrderTaskItemService orderTaskItemService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WareOrderTaskEntity> page = this.page(
                new Query<WareOrderTaskEntity>().getPage(params),
                new QueryWrapper<WareOrderTaskEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    /**
     * @MethodName: lockArticleStockByOrder
     * @Description: lock the stock of articles for each product. We'll work in the ways of both top-down and bottom-up.
     *              We prefer local transactions plus processes instead of distributed transactions, e.g., 2PC, 3PC, XA, Seata, etc.
     *              It's similar as TCC. This will support high concurrency requests and idempotent api.
     *              Top-Down: we'll create the structure from WareOrderTaskEntity -> WareOrderTaskItemEntity -> WareOrderTaskItemArticleEntity
     *              the initial status would be INIT.
     *              Bottom-Up: The status will be promoted to next phase if it succeeded with local transactions. After all of the lower level done,
     *              the status will be rolled up and trigger to promote the higher level. The corresponding action to promote such objects will be stopped
     *              in case of any issue. So that we could get the chance to fix the issue and re-run the action until the process succeeded.
     *              In case of any failure, we could unlock those stocks of specific articles. We could decide how to proceed with the failed transactions
     *              based on any policy or strategy, e.g., time threshold, retrial times, etc.
     *
     * @Param: [vo]
     * @Return: void
     * @Author: Beiji Ma
     * @Date: 2021-12-14 23:33
    */
    public void lockArticleStockByOrder(WareOrderVo vo) {
        // create Order Task to set the basic information for the transaction
        WareOrderTaskEntity orderTaskEntity = WareOrderTaskEntity.builder()
                .orderId(vo.getId())
                .orderSn(vo.getOrderSn())
                .taskStatus(vo.getTaskStatus())
                .taskComment(vo.getTaskComment() == null ? "" : vo.getTaskComment())
                .modified(vo.getModified())
                .originated(vo.getOriginated())
                .build();
        this.save(orderTaskEntity);

        // create Order Task Item for each product in the order list
        List<WareOrderTaskItemEntity> wareOrderTaskItemEntityList = vo.getProducts().stream()
                .map(product -> {
                    WareOrderTaskItemEntity orderTaskItemEntity = WareOrderTaskItemEntity.builder()
                            .orderId(product.getOrderId())
                            .productId(product.getProductId())
                            .quantity(product.getQuantity())
                            .taskItemStatus(product.getTaskItemStatus())
                            .originated(product.getOriginated())
                            .modified(product.getModified())
                            .build();
                    return orderTaskItemEntity;
                })
                .collect(Collectors.toList());
        orderTaskItemService.saveBatch(wareOrderTaskItemEntityList);


    }
}
