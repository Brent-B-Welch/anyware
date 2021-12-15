/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareSkuService
 * @packageName: org.corpname.anymall.ware.service
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:27
 **/
package org.corpname.anymall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.to.ProductStockVo;
import org.corpname.anymall.common.to.ProductWithArticlesVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.ware.entity.WareSkuEntity;

import java.util.List;
import java.util.Map;

public interface WareSkuService extends IService<WareSkuEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ProductStockVo> getProductWithStock(List<ProductWithArticlesVo> vos);

}
