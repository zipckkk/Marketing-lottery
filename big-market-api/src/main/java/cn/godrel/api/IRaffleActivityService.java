package cn.godrel.api;

import cn.godrel.api.dto.ActivityDrawRequestDTO;
import cn.godrel.api.dto.ActivityDrawResponseDTO;
import cn.godrel.api.dto.UserActivityAccountRequestDTO;
import cn.godrel.api.dto.UserActivityAccountResponseDTO;
import cn.godrel.types.model.Response;

/**
 * ClassName: IRaffleActivityService
 * Package: cn.godrel.api
 * Description: 抽奖活动服务
 *
 * @Author 张世召
 * @Create 2025/3/18 17:46
 * @Version 1.0
 */
public interface IRaffleActivityService {
    /**
     * 活动装配，数据预热缓存
     * @param activityId 活动ID
     * @return 装配结果
     */
    Response<Boolean> armory(Long activityId);

    /**
     * 活动抽奖接口
     * @param request 请求对象
     * @return 返回结果
     */
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);

    /**
     * 日历签到返利接口
     *
     * @param userId 用户ID
     * @return 签到结果
     */
    Response<Boolean> calendarSignRebate(String userId);

    /**
     * 判断是否完成日历签到返利接口
     *
     * @param userId 用户ID
     * @return 签到结果 true 已签到，false 未签到
     */
    Response<Boolean> isCalendarSignRebate(String userId);

    /**
     * 查询用户活动账户
     *
     * @param request 请求对象「活动ID、用户ID」
     * @return 返回结果「总额度、月额度、日额度」
     */
    Response<UserActivityAccountResponseDTO> queryUserActivityAccount(UserActivityAccountRequestDTO request);

}
