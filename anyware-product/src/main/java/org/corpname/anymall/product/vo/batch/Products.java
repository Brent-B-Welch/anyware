package org.corpname.anymall.product.vo.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Products {
    @JsonProperty("products")
    private List<Product> proudcts;
}
