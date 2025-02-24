package cn.godrel.test.infrastructure;

import cn.godrel.infrastructure.persistent.dao.IAwardDao;
import cn.godrel.infrastructure.persistent.po.Award;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: AwarfDaoTest
 * Package: cn.godrel.test.infrastructure
 * Description:奖品持久化单元测试
 * @Author 张世召
 * @Create 2025/2/24 17:14
 * @Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class )
@SpringBootTest
public class AwardDaoTest {
    @Resource
    private IAwardDao awardDao;

    @Test
    public void test_queryAwardList(){
        List<Award> awards = awardDao.queryAwardList();
        log.info("测试结果：{}", JSON.toJSONString(awards));
    }
}
