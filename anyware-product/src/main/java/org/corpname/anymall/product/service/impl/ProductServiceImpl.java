package org.corpname.anymall.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.to.ProductStockVo;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.Query;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.product.dao.ProductDao;
import org.corpname.anymall.product.entity.ProductArticleRelationEntity;
import org.corpname.anymall.product.entity.ProductEntity;
import org.corpname.anymall.product.feign.WareFeignService;
import org.corpname.anymall.product.service.ProductArticleRelationService;
import org.corpname.anymall.product.service.ProductService;
import org.corpname.anymall.common.to.ProductArticleRelationVo;
import org.corpname.anymall.common.to.ProductWithArticlesVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("wareProductService")
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductArticleRelationService productArticleRelationService;
    @Autowired
    WareFeignService wareFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductEntity> page = this.page(
                new Query<ProductEntity>().getPage(params),
                new QueryWrapper<ProductEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveList(List<ProductEntity> collect) {
        productDao.saveList(collect);
    }

    @Override
    public ProductWithArticlesVo getProductWithArticlesByProductId(Long productId) {

        ProductEntity productEntity = this.getById(productId);
        ProductWithArticlesVo vo = new ProductWithArticlesVo();
        BeanUtils.copyProperties(productEntity, vo);
        List<ProductArticleRelationEntity> productArticleRelationEntities = productArticleRelationService.list(new QueryWrapper<ProductArticleRelationEntity>().eq("product_id", productId));

        List<ProductArticleRelationVo> collect = productArticleRelationEntities.stream()
                .map(relation -> {
                    ProductArticleRelationVo relationVo = new ProductArticleRelationVo();
                    BeanUtils.copyProperties(relation, relationVo);
                    return relationVo;
                }).collect(Collectors.toList());
        vo.setProductArticleRelations(collect);
        return vo;
    }

    @Override
    public PageUtils getProductWithStock(Map<String, Object> params) {
        QueryWrapper<ProductEntity> queryWrapper = new QueryWrapper<ProductEntity>();
        IPage<ProductEntity> page = this.page(
                new Query<ProductEntity>().getPage(params), queryWrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<ProductEntity> records = page.getRecords();
        List<ProductWithArticlesVo> productVoList = records.stream()
                .map((productEntity -> {
                    ProductWithArticlesVo productVo = new ProductWithArticlesVo();
                    BeanUtils.copyProperties(productEntity, productVo);

                    List<ProductArticleRelationEntity> productArticleRelationEntities = productArticleRelationService.list(new QueryWrapper<ProductArticleRelationEntity>().eq("product_id", productEntity.getId()));

                    List<ProductArticleRelationVo> relationVoList = productArticleRelationEntities.stream()
                            .map(relation -> {
                                ProductArticleRelationVo relationVo = new ProductArticleRelationVo();
                                BeanUtils.copyProperties(relation, relationVo);
                                return relationVo;
                            }).collect(Collectors.toList());

                    productVo.setProductArticleRelations(relationVoList);

                    return productVo;
                }))
                .collect(Collectors.toList());

        R r = wareFeignService.getProductWithStock(productVoList);
        if (r.getCode() == 0) {
            log.info("yeah!");
            List<ProductStockVo> productStockVoList = r.getData("data", new TypeReference<List<ProductStockVo>>(){});
            pageUtils.setList(productStockVoList);
            return pageUtils;
        } else {
            return null;
        }

    }

}
