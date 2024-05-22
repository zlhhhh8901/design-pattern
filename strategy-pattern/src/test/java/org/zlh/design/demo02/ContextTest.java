package org.zlh.design.demo02;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zlh.design.demo02.event.MJCouponDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ContextTest {
    private final Logger logger = LoggerFactory.getLogger(ContextTest.class);

    @Test
    public void discountAmountTest(){
        // 满100减10，商品100元
        Context<Map<String, String>> context = new Context<>(new MJCouponDiscount());
        Map<String,String> mapReq = new HashMap<String, String>();
        mapReq.put("x","100");
        mapReq.put("n","10");
        BigDecimal res = context.discountAmount(mapReq, new BigDecimal(100));
        logger.info("满减优惠后金额为：{}", res);
    }
}
