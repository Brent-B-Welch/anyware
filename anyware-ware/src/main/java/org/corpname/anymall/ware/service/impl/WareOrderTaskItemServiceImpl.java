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
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WareOrderTaskItemEntity> page = this.page(
                new Query<WareOrderTaskItemEntity>().getPage(params),
                new QueryWrapper<WareOrderTaskItemEntity>()
        );

        return new PageUtils(page);
    }
}
