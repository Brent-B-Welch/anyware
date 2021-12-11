package org.anyware.anyamall.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductItem {
    @JsonProperty("art_id")
    private Long articleId;
    @JsonProperty("amount_of")
    private Integer amountOf;
}
