package org.corpname.anymall.common.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductArticleRelationVo {
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("art_id")
    private Long artId;
    @JsonProperty("amount_of")
    private Integer amountOf;
}
