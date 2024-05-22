package org.zlh.design.demo01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyApplicationTest {
    @Resource
    private DiscountStrategyFactory strategyFactory;

    @Test
    public void test(){
        DiscountStrategy discountStrategy = strategyFactory.chooseStrategy("1");
        Double result = discountStrategy.discount(100D);
        System.out.println(result);
    }
}
