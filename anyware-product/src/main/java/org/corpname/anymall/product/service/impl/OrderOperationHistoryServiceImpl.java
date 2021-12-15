/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderOperationHistoryServiceImpl
 * @packageName: org.corpname.anymall.product.service.impl
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:44
 **/
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
    /**
     * @methodName: queryPage
     * @description: default way to return WorkOrderTaskItemEntity which is not preferable
     *               TODO: replace with vo instead of entity
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.PageUtils
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:43
     */
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderOperationHistoryEntity> page = this.page(
                new Query<OrderOperationHistoryEntity>().getPage(params),
                new QueryWrapper<OrderOperationHistoryEntity>()
        );

        return new PageUtils(page);
    }
}
