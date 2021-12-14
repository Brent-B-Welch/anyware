package org.corpname.anymall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.product.entity.OrderOperationHistoryEntity;

import java.util.Map;

public interface OrderOperationHistoryService extends IService<OrderOperationHistoryEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
