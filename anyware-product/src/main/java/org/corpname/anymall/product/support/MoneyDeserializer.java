package org.corpname.anymall.product.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: MoneyDeserializer
 * @packageName: org.corpname.anymall.product.support
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date: 2021-12-15 22:53
 **/

@JsonComponent
public class MoneyDeserializer extends StdDeserializer<Money> {
    public MoneyDeserializer() {
        super(Money.class);
    }

    @Override
    public Money deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
        return Money.of(CurrencyUnit.of("USD"), parser.getDecimalValue().multiply(NumberUtils.createBigDecimal("100")));
    }
}
