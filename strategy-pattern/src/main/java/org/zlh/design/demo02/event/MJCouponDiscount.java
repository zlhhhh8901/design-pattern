package org.zlh.design.demo02.event;

import org.zlh.design.demo02.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 满减
 * 1. 判断满足x元后-n元，否则不减
 * 2. 最低支付金额1元
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {

    @Override
    public BigDecimal discountAmount(Map<String,String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");

        // 小于商品金额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        // 减去优惠金额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;

        return discountAmount;
    }

}
