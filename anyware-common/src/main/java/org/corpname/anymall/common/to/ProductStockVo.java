package org.corpname.anymall.common.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductStockVo {
    @JsonProperty("product_id")
    private Long productId;
    private String name;
    private Integer stock;
}
