package org.zlh.design.demo01;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于SpringBoot实现策略模式
 */
@Component
public class DiscountStrategyFactory implements InitializingBean {
    @Autowired
    private ApplicationContext applicationContext;

    private final Map<String, DiscountStrategy> discountStrategies = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * 在bean初始化阶段，使用map存储所有策略
         * 这么设计符合“开闭原则”，即“对扩展开放对修改关闭”
         */
        Map<String, DiscountStrategy> discountStrategyMap = applicationContext.getBeansOfType(DiscountStrategy.class);
        discountStrategyMap.forEach((key, value) -> discountStrategies.put(value.mark(), value));
    }

    // 选择及获取策略
    public DiscountStrategy chooseStrategy(String type){
        return discountStrategies.get(type);
    }
}
