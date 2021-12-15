/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareSkuServiceImpl
 * @packageName: org.corpname.anymall.ware.service.impl
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:28
 **/
package org.corpname.anymall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.to.ProductStockVo;
import org.corpname.anymall.common.to.ProductWithArticlesVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.ware.dao.WareSkuDao;
import org.corpname.anymall.ware.entity.WareSkuEntity;
import org.corpname.anymall.ware.service.WareSkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {
    @Override
    /**
     * @methodName: queryPage
     * @description: default way to return WorkOrderTaskItemEntity which is not preferable
     *               TODO: replace with vo instead of entity
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.PageUtils
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:27
     */
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                new QueryWrapper<WareSkuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    /**
     * @MethodName: getProductWithStock
     * @Description: The method is used to get the rough estimation for the stock of products
     *               based on scanning the stock of articles. The stock of products should
     *               be materialized or recorded from the begging of import of the
     *               inventory so that we can avoid the algorithm like this. Maybe a daemon
     *               process could work for it, e.g., a cronjob, etc.
     *
     *               The algorithm is based on the concerns below:
     *               Each product must have at least one unique article(component), which will decide
     *               the uppper limit of the stock for such product. It's similar with Barrel theory.
     *               Unfortunately, it's not always the truth.
     *
     *               You will get the stock as 0 in case material shortage.
     *
     *               TODO: replace it with the precise business logic.
     *
     * @Param: [vos]
     * @Return: java.util.List<org.corpname.anymall.common.to.ProductStockVo>
     * @Author: Beiji Ma
     * @Date: 2021-12-14 13:00
    */
    public List<ProductStockVo> getProductWithStock(List<ProductWithArticlesVo> vos) {
        List<ProductStockVo> collect = vos.stream()
                .map(productWithArticlesVo -> {
                    ProductStockVo productStockVo = new ProductStockVo();
                    BeanUtils.copyProperties(productWithArticlesVo, productStockVo);
                    productStockVo.setProductId(productWithArticlesVo.getId());

                    Integer stock = productWithArticlesVo.getProductArticleRelations()
                            .stream()
                            .map(relVo -> {
                                return Optional.ofNullable(this.getById(relVo.getArtId()))
                                        .map(wareSku -> {
                                            log.info("{} {} {} {} {}", relVo.getProductId() == null ? "": relVo.getProductId(), relVo.getArtId(), relVo.getAmountOf(), wareSku.getStock(), wareSku.getStock() / relVo.getAmountOf());
                                            return wareSku.getStock() / relVo.getAmountOf();
                                        })
                                        .orElse(0);
                            })
                            .min(Integer::compareTo)
                            .get();
                    productStockVo.setStock(stock);
                    return productStockVo;
                }).collect(Collectors.toList());
        return collect;
    }
}
