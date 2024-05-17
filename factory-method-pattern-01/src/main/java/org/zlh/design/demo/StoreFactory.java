package org.zlh.design.demo;

import org.zlh.design.demo.store.ICommodity;
import org.zlh.design.demo.store.impl.CardCommodityService;
import org.zlh.design.demo.store.impl.CouponCommodityService;
import org.zlh.design.demo.store.impl.GoodsCommodityService;

public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (commodityType == null) return null;
        if (commodityType == 1) return new CouponCommodityService();
        if (commodityType == 2) return new GoodsCommodityService();
        if (commodityType == 3) return new CardCommodityService();
        throw new RuntimeException("不存在该商品服务类型");
    }

}
