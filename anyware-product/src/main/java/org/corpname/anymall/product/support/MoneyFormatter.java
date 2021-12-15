package org.corpname.anymall.product.support;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: MoneyFormatter
 * @packageName: org.corpname.anymall.product.support
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date: 2021-12-15 22:59
 **/
@Component
public class MoneyFormatter implements Formatter<Money> {

    @Override
    /**
     * @methodName: parse
     * @description: convert a string into a Money object
     * @param: [s, locale]
     * @return: org.joda.money.Money
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 23:05
     */
    public Money parse(String s, Locale locale) throws ParseException {
        if (NumberUtils.isParsable(s)) {
            return Money.of(CurrencyUnit.of("USD"), NumberUtils.createBigDecimal(s));
        } else if (StringUtils.isNotEmpty(s)) {
            String[] split = StringUtils.split(s, " ");
            if (split != null && split.length == 2 && NumberUtils.isParsable(split[1])) {
                return Money.of(CurrencyUnit.of("split[0]"), NumberUtils.createBigDecimal(split[1]));
            } else {
                throw new ParseException(s, 0);
            }
        }
        throw new ParseException(s, 0);
    }

    @Override
    /**
     * @methodName: print
     * @description: convert a Money object into a string
     * @param: [money, locale]
     * @return: java.lang.String
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 23:06
     */
    public String print(Money money, Locale locale) {
        if (money == null) {
            return null;
        }
        return money.getCurrencyUnit().getCode() + " " + money.getAmount();
    }
}
