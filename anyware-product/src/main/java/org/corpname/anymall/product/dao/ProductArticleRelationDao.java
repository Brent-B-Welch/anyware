package org.corpname.anymall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.corpname.anymall.product.entity.ProductArticleRelationEntity;

import java.util.List;

@Mapper
public interface ProductArticleRelationDao extends BaseMapper<ProductArticleRelationEntity> {

    void saveOrUpdateList(@Param("entities")List<ProductArticleRelationEntity> collect);
}
