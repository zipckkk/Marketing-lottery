package cn.godrel.test.trigger;

import cn.godrel.api.IRaffleActivityService;
import cn.godrel.api.dto.ActivityDrawRequestDTO;
import cn.godrel.api.dto.ActivityDrawResponseDTO;
import cn.godrel.api.dto.UserActivityAccountRequestDTO;
import cn.godrel.api.dto.UserActivityAccountResponseDTO;
import cn.godrel.types.model.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ClassName: RaffleActivityControllerTest
 * Package: cn.godrel.test.trigger
 * Description:
 *
 * @Author 张世召
 * @Create 2025/3/19 17:02
 * @Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityControllerTest {
    @Resource
    private IRaffleActivityService raffleActivityService;

    @Test
    public void test_armory() {
        Response<Boolean> response = raffleActivityService.armory(100301L);
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_draw() {
        ActivityDrawRequestDTO request = new ActivityDrawRequestDTO();
        request.setActivityId(100301L);
        request.setUserId("xiaofuge");
        Response<ActivityDrawResponseDTO> response = raffleActivityService.draw(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_calendarSignRebate(){
//        Response<Boolean> response = raffleActivityService.calendarSignRebate("xiaofuge");
        Response<Boolean> response = raffleActivityService.calendarSignRebate("godrel");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_isCalendarSignRebate() {
//        Response<Boolean> response = raffleActivityService.isCalendarSignRebate("xiaofuge");
        Response<Boolean> response = raffleActivityService.isCalendarSignRebate("godrel");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }


    @Test
    public void test_queryUserActivityAccount() {
        UserActivityAccountRequestDTO request = new UserActivityAccountRequestDTO();
        request.setActivityId(100301L);
        request.setUserId("xiaofuge");

        // 查询数据
        Response<UserActivityAccountResponseDTO> response = raffleActivityService.queryUserActivityAccount(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }


}
