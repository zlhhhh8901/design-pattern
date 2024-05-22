package org.zlh.design.demo01.impl;

import org.springframework.stereotype.Component;
import org.zlh.design.demo01.DiscountStrategy;


/**
 * 5折
 */
@Component
public class Discount5Strategy implements DiscountStrategy {
    @Override
    public Double discount(Double price) {
        return price * 0.5;
    }

    @Override
    public String mark() {
        // 最好用枚举
        return "2";
    }
}
