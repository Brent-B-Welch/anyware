package org.corpname.anymall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.to.OrderItemCreationVo;
import org.corpname.anymall.common.to.WareOrderVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.product.entity.OrderEntity;
import org.corpname.anymall.product.vo.OrderInDetailVo;

import java.util.List;
import java.util.Map;

public interface OrderService extends IService<OrderEntity> {
    PageUtils queryPage(Map<String, Object> params);

    void createOrder(List<OrderItemCreationVo> orderVos);

    OrderInDetailVo getOrderInDetail(Long id);

    WareOrderVo lockArticleStockByOrder(Long id);
}
