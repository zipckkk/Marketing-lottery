package cn.godrel.test.domain;

import cn.godrel.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ClassName: StrategyArmoryTest
 * Package: cn.godrel.test.domain
 * Description:
 * @Author 张世召
 * @Create 2025/2/26 11:25
 * @Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class )
@SpringBootTest
public class StrategyArmoryTest {

    @Resource
    private IStrategyArmory strategyArmory;
    
    @Test
    public void testStrategyArmory(){
        strategyArmory.assembleLotteryStrategy(100002L);
    }

    @Test
    public void testGetAssembleRandomVal(){
        for (int i = 0; i < 1000; i++) {
            log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
        }
//        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
//        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));

    }
}
