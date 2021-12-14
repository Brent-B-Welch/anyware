package org.corpname.anymall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.product.entity.OrderItemEntity;

import java.util.Map;

public interface OrderItemService extends IService<OrderItemEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
