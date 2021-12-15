package org.corpname.anymall.product.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: MoneySerializer
 * @packageName: org.corpname.anymall.product.support
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date: 2021-12-15 22:57
 **/
@JsonComponent
public class MoneySerializer extends StdSerializer<Money> {
    protected MoneySerializer() {
        super(Money.class);
    }

    @Override
    public void serialize(Money money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(money.getAmount().divide(NumberUtils.createBigDecimal("100")));
    }
}
