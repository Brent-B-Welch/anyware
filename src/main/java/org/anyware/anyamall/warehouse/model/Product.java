package org.anyware.anyamall.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Product {
    private String name;
    // TODO: the 2 annotations(setter and getter) cause the escape objects below
    @JsonProperty("contain_articles")
    private List<ProductItem> items;
}
