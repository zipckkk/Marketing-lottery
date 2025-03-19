package cn.godrel.api;

import cn.godrel.api.dto.ActivityDrawRequestDTO;
import cn.godrel.api.dto.ActivityDrawResponseDTO;
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

}
