package org.corpname.anymall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.product.dao.OrderOperationHistoryDao;
import org.corpname.anymall.product.entity.OrderOperationHistoryEntity;
import org.corpname.anymall.product.service.OrderOperationHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service("wareOrderOperationHistoryService")
public class OrderOperationHistoryServiceImpl extends ServiceImpl<OrderOperationHistoryDao, OrderOperationHistoryEntity> implements OrderOperationHistoryService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderOperationHistoryEntity> page = this.page(
                new Query<OrderOperationHistoryEntity>().getPage(params),
                new QueryWrapper<OrderOperationHistoryEntity>()
        );

        return new PageUtils(page);
    }
}
