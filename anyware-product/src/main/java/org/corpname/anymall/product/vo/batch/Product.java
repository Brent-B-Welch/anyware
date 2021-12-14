package org.corpname.anymall.product.vo.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String name;
    @JsonProperty("contain_articles")
    private List<ProductArticleRelation> items;
}
