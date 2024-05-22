package org.zlh.design.demo02;

import java.math.BigDecimal;

/**
 * 策略模式的控制类，外部可以传递不同的策略实现，在通过统一的方法执行优惠策略计算
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}
