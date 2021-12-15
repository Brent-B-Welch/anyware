/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductArticleRelationEntity
 * @packageName: org.corpname.anymall.product.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:42
 **/
package org.corpname.anymall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("ware_product_article_relation")
public class ProductArticleRelationEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * Product ID
     */
    @JsonProperty("product_id")
    private Long productId;
    /**
     * Article ID
     */
    @JsonProperty("art_id")
    private Long artId;
    /**
     * amount_of
     */
    @JsonProperty("amount_of")
    private Integer amountOf;

    /**
     * status
     */
//    @TableLogic(value = "1", delval = "0")
//    private Integer deleted;
}
