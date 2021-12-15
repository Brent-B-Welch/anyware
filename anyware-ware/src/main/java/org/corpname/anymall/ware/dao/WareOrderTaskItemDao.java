/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskItemDao
 * @packageName: org.corpname.anymall.ware.dao
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:22
 **/
package org.corpname.anymall.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.corpname.anymall.ware.entity.WareOrderTaskItemEntity;

@Mapper
public interface WareOrderTaskItemDao extends BaseMapper<WareOrderTaskItemEntity> {
}
