package org.corpname.anymall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.ware.entity.WareOrderTaskItemEntity;

import java.util.Map;

public interface WareOrderTaskItemService extends IService<WareOrderTaskItemEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
