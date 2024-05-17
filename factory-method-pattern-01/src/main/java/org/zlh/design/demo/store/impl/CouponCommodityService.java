package org.zlh.design.demo.store.impl;

import lombok.extern.slf4j.Slf4j;
import org.zlh.design.demo.coupon.CouponResult;
import org.zlh.design.demo.coupon.CouponService;
import org.zlh.design.demo.store.ICommodity;

import java.util.Map;


/**
 * 发放“优惠券”奖品实现类
 */
@Slf4j
public class CouponCommodityService implements ICommodity {

    private CouponService couponService = new CouponService();
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        CouponResult result = couponService.sendCoupon(uId, commodityId, bizId);
        if(!result.getCode().equals("0000")) throw new RuntimeException(result.getInfo());
    }
}
