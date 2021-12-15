/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskItemServiceImpl
 * @packageName: org.corpname.anymall.ware.service.impl
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:25
 **/
package org.corpname.anymall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.ware.dao.WareOrderTaskItemDao;
import org.corpname.anymall.ware.entity.WareOrderTaskItemEntity;
import org.corpname.anymall.ware.service.WareOrderTaskItemService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service("wareOderTaskItemService")
public class WareOrderTaskItemServiceImpl extends ServiceImpl<WareOrderTaskItemDao, WareOrderTaskItemEntity> implements WareOrderTaskItemService {
    @Override
    /**
     * @methodName: queryPage
     * @description: default way to return WorkOrderTaskItemEntity which is not preferable
     *               TODO: replace with vo instead of entity
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.PageUtils
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:25
     */
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WareOrderTaskItemEntity> page = this.page(
                new Query<WareOrderTaskItemEntity>().getPage(params),
                new QueryWrapper<WareOrderTaskItemEntity>()
        );

        return new PageUtils(page);
    }
}
