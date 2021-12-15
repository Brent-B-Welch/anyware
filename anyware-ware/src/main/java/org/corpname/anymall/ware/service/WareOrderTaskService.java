/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskService
 * @packageName: org.corpname.anymall.ware.service
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:25
 **/
package org.corpname.anymall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.to.WareOrderVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    /**
     * @methodName: queryPage
     * @description: TODO
     * @param:
     * @return:
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 17:17
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @methodName: lockArticleStockByOrder
     * @description: TODO
     * @param:
     * @return:
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 17:17
     */
    void lockArticleStockByOrder(WareOrderVo vo);
}
