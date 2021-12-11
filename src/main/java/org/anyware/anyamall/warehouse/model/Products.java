package org.anyware.anyamall.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Products {
    // TODO: the 2 annotations(setter and getter) cause the escape objects below
    @JsonProperty("products")
    private List<Product> proudcts;
}
