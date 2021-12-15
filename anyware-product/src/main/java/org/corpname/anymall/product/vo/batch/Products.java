/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: Products
 * @packageName: org.corpname.anymall.product.vo.batch
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:48
 **/
package org.corpname.anymall.product.vo.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Products {
    @JsonProperty("products")
    private List<Product> proudcts;
}
