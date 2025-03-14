package cn.godrel.test.infrastructure;

import cn.godrel.infrastructure.persistent.dao.IRaffleActivityDao;
import cn.godrel.infrastructure.persistent.po.RaffleActivity;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ClassName: RaffleActivityDaoTest
 * Package: cn.godrel.test.infrastructure
 * Description: 抽奖活动配置Dao测试
 *
 * @Author 张世召
 * @Create 2025/3/14 15:22
 * @Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityDaoTest {
    @Resource
    private IRaffleActivityDao raffleActivityDao;

    @Test
    public void testQueryRaffleActivityByActivityId() {
        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(100301L);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivity));
    }

}
