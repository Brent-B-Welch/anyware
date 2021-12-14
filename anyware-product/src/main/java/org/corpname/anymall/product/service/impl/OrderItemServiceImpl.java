package org.corpname.anymall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.product.dao.OrderItemDao;
import org.corpname.anymall.product.entity.OrderItemEntity;
import org.corpname.anymall.product.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service("wareOrderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(
                new Query<OrderItemEntity>().getPage(params),
                new QueryWrapper<OrderItemEntity>()
        );

        return new PageUtils(page);
    }
}
