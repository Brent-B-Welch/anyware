/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareSkuEntity
 * @packageName: org.corpname.anymall.ware.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:24
 **/
package org.corpname.anymall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("ware_sku")
public class WareSkuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * art_id
     */
    @JsonProperty("art_id")
    private Long artId;
    /**
     * name
     */
    private String name;
    /**
     * stock
     */
    private Integer stock;

    /**
     * status
     */
//    @TableLogic(value = "1", delval = "0")
//    private Integer deleted;
}
