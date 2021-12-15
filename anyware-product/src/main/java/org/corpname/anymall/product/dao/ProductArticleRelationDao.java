/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductArticleRelationDao
 * @packageName: org.corpname.anymall.product.dao
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:39
 **/
package org.corpname.anymall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.corpname.anymall.product.entity.ProductArticleRelationEntity;

import java.util.List;

@Mapper
public interface ProductArticleRelationDao extends BaseMapper<ProductArticleRelationEntity> {

    /**
     * @methodName: saveOrUpdateList
     * @description: TODO
     * @param:
     * @return:
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 17:17
     */
    void saveOrUpdateList(@Param("entities")List<ProductArticleRelationEntity> collect);
}
