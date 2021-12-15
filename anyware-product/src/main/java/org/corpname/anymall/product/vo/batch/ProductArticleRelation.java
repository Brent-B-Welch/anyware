/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductArticleRelation
 * @packageName: org.corpname.anymall.product.vo.batch
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:47
 **/
package org.corpname.anymall.product.vo.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductArticleRelation {
    @JsonProperty("art_id")
    /**
     * art_id
     */
    private Long artId;
    @JsonProperty("amount_of")
    /**
     * amount_of
     */
    private Integer amount;
}
