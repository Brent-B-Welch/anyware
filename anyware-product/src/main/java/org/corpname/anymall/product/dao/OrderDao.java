package org.corpname.anymall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.corpname.anymall.product.entity.OrderEntity;

@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
}
