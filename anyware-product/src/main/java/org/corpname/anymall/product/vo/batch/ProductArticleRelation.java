package org.corpname.anymall.product.vo.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductArticleRelation {
    @JsonProperty("art_id")
    private Long artId;
    @JsonProperty("amount_of")
    private Integer amount;
}
