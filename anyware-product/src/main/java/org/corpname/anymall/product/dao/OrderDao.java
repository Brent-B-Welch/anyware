/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderDao
 * @packageName: org.corpname.anymall.product.dao
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:39
 **/
package org.corpname.anymall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.corpname.anymall.product.entity.OrderEntity;

@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
}
