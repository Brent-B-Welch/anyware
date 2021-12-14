package org.corpname.anymall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.to.WareOrderVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {
    PageUtils queryPage(Map<String, Object> params);

    void lockArticleStockByOrder(WareOrderVo vo);
}
