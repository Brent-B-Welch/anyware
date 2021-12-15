/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskItemService
 * @packageName: org.corpname.anymall.ware.service
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:24
 **/
package org.corpname.anymall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.ware.entity.WareOrderTaskItemEntity;

import java.util.Map;

public interface WareOrderTaskItemService extends IService<WareOrderTaskItemEntity> {
    /**
     * @methodName: queryPage
     * @description: TODO
     * @param:
     * @return:
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 17:16
     */
    PageUtils queryPage(Map<String, Object> params);
}
