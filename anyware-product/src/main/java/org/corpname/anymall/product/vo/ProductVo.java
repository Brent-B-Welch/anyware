/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductVo
 * @packageName: org.corpname.anymall.product.vo
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:48
 **/
package org.corpname.anymall.product.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.corpname.anymall.product.support.MoneyDeserializer;
import org.corpname.anymall.product.support.MoneySerializer;
import org.joda.money.Money;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductVo {
    /**
     * id
     */
    private Long id;
    /**
     * name
     */
    @NotNull
    private String name;
    /**
     * price
     */
    @NotNull
    @JsonSerialize(using = MoneySerializer.class)
    @JsonDeserialize(using = MoneyDeserializer.class)
    private Money price;
}
