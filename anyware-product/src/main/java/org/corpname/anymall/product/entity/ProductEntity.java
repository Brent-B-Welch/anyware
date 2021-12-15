/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductEntity
 * @packageName: org.corpname.anymall.product.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:42
 **/
package org.corpname.anymall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("ware_product")
public class ProductEntity {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * name
     */
    private String name;

    /**
     * status
     */
//    @TableLogic(value = "1", delval = "0")
//    private Integer deleted;
}
