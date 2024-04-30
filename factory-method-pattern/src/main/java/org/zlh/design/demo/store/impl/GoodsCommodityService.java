package org.zlh.design.demo.store.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.zlh.design.demo.goods.DeliverReq;
import org.zlh.design.demo.goods.GoodsService;
import org.zlh.design.demo.store.ICommodity;

import java.util.Map;

/**
 * 发放“实物商品”奖品实现类
 */
@Slf4j
public class GoodsCommodityService implements ICommodity {

    private GoodsService goodsService = new GoodsService();
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName("sos");
        deliverReq.setUserPhone("110");
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean aBoolean = goodsService.deliverGoods(deliverReq);

        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSONString(extMap));
        log.info("测试结果[优惠券]：{}", aBoolean);

        if (!aBoolean) throw new RuntimeException("实物商品发放失败");
    }
}
