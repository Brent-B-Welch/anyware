package org.corpname.anymall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.product.entity.ProductEntity;
import org.corpname.anymall.common.to.ProductWithArticlesVo;

import java.util.List;
import java.util.Map;

public interface ProductService extends IService<ProductEntity> {
    PageUtils queryPage(Map<String, Object> params);
    void saveList(List<ProductEntity> collect);

    ProductWithArticlesVo getProductWithArticlesByProductId(Long productId);

    PageUtils getProductWithStock(Map<String, Object> params);
}
