package org.corpname.anymall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.corpname.anymall.product.entity.ProductEntity;

import java.util.List;

@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
    void saveList(@Param("entities")List<ProductEntity> entities);

}
