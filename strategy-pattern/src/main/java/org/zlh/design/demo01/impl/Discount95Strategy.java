package org.zlh.design.demo01.impl;

import org.springframework.stereotype.Component;
import org.zlh.design.demo01.DiscountStrategy;

/**
 * 95折
 */
@Component
public class Discount95Strategy implements DiscountStrategy {
    @Override
    public Double discount(Double price) {
        return price * 0.95;
    }

    @Override
    public String mark() {
        // 最好还是用枚举
        return "1";
    }
}
