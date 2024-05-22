package org.zlh.design.demo01;

public interface DiscountStrategy {
    // 定义抽象策略接口
    Double discount(Double price);

    // 定义策略算法标识
    String mark();
}
