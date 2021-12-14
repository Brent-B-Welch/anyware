package org.corpname.anymall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.product.entity.ProductArticleRelationEntity;

import java.util.List;
import java.util.Map;

public interface ProductArticleRelationService extends IService<ProductArticleRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void batchSaveOrUpdate(List<ProductArticleRelationEntity> collect);
}
