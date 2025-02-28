package cn.godrel.test.domain;

import cn.godrel.domain.strategy.service.armory.IStrategyArmory;
import cn.godrel.domain.strategy.service.armory.IStrategyDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Deque;
import java.util.LinkedList;

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
    @Resource
    private IStrategyDispatch strategyDispatch;
    
    @Before
    public void testStrategyArmory(){
        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
        log.info("测试结果:{}",success);
    }

    @Test
    public void testGetAssembleRandomVal(){
        log.info("测试结果：{} - 奖品ID值", strategyDispatch.getRandomAwardId(100001L));
    }

    @Test
    public void testGetAssembleRandomRuleWeightValue(){
        log.info("测试结果：{} - 4000策略配置", strategyDispatch.getRandomAwardId(100001L, "4000:102,103,104,105"));
        log.info("测试结果：{} - 5000策略配置", strategyDispatch.getRandomAwardId(100001L, "5000:102,103,104,105,106,107"));
        log.info("测试结果：{} - 6000策略配置", strategyDispatch.getRandomAwardId(100001L, "6000:102,103,104,105,106,107,108,109"));
    }

}
