/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductArticleRelationServiceImpl
 * @packageName: org.corpname.anymall.product.service.impl
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:46
 **/
package org.corpname.anymall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.product.dao.ProductArticleRelationDao;
import org.corpname.anymall.product.entity.ProductArticleRelationEntity;
import org.corpname.anymall.product.service.ProductArticleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("wareProductArticleRelationService")
@Slf4j
public class ProductArticleRelationServiceImpl extends ServiceImpl<ProductArticleRelationDao, ProductArticleRelationEntity> implements ProductArticleRelationService {
    @Autowired
    private ProductArticleRelationDao productArticleRelationDao;
    @Override
    /**
     * @methodName: queryPage
     * @description: TODO
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.PageUtils
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:46
     */
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductArticleRelationEntity> page = this.page(
                new Query<ProductArticleRelationEntity>().getPage(params),
                new QueryWrapper<ProductArticleRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    /**
     * @methodName: batchSaveOrUpdate
     * @description: TODO
     * @param: [collect]
     * @return: void
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:46
     */
    public void batchSaveOrUpdate(List<ProductArticleRelationEntity> collect) {
        productArticleRelationDao.saveOrUpdateList(collect);
    }
}
