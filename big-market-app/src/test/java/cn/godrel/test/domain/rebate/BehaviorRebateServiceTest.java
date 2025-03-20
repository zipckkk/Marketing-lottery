package cn.godrel.test.domain.rebate;

import cn.godrel.domain.activity.service.armory.IActivityArmory;
import cn.godrel.domain.rebate.model.entity.BehaviorEntity;
import cn.godrel.domain.rebate.model.valobj.BehaviorTypeVO;
import cn.godrel.domain.rebate.service.IBehaviorRebateService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * ClassName: BehaviorRebateServiceTest
 * Package: cn.godrel.test.domain.rebate
 * Description:
 *
 * @Author 张世召
 * @Create 2025/3/20 15:42
 * @Version 1.0
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BehaviorRebateServiceTest {

    @Resource
    private IBehaviorRebateService behaviorRebateService;

    @Resource
    private IActivityArmory activityArmory;

//    @Before
//    public void init() {
//        activityArmory.assembleActivitySkuByActivityId(100301L);
//    }

    @Test
    public void test_createOrder() throws InterruptedException {
        BehaviorEntity behaviorEntity = new BehaviorEntity();
        behaviorEntity.setUserId("xiaofuge");
        behaviorEntity.setBehaviorTypeVO(BehaviorTypeVO.SIGN);
        // 重复的 OutBusinessNo 会报错唯一索引冲突，这也是保证幂等的手段，确保不会多记账
        behaviorEntity.setOutBusinessNo("20240501");

        List<String> orderIds = behaviorRebateService.createOrder(behaviorEntity);
        log.info("请求参数：{}", JSON.toJSONString(behaviorEntity));
        log.info("测试结果：{}", JSON.toJSONString(orderIds));

//        new CountDownLatch(1).await();
    }

}
