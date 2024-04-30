package org.zlh.design.demo.store;

import java.util.Map;

public interface ICommodity {
    /**
     * 工厂方法设计模式实践：
     * 无论发放何种奖品，都只需要通过本接口，保证了出入参的一致性
     * @param uId 用户id
     * @param commodityId 奖品id
     * @param bizId 业务id
     * @param extMap 扩展字段
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
