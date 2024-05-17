package org.zlh.design.demo.store.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.zlh.design.demo.card.IQiYiCardService;
import org.zlh.design.demo.store.ICommodity;

import java.util.Map;

/**
 * 发放“第三方兑换卡”奖品实现类
 */
@Slf4j
public class CardCommodityService implements ICommodity {
    IQiYiCardService iQiYiCardService = new IQiYiCardService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        iQiYiCardService.grantToken("110", bizId);

        log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSONString(extMap));
        log.info("测试结果[爱奇艺兑换卡]：success");
    }
}
