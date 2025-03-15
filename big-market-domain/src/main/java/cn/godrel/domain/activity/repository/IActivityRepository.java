package cn.godrel.domain.activity.repository;

import cn.godrel.domain.activity.model.entity.ActivityCountEntity;
import cn.godrel.domain.activity.model.entity.ActivityEntity;
import cn.godrel.domain.activity.model.entity.ActivitySkuEntity;

/**
 * ClassName: IActivityRepository
 * Package: cn.godrel.domain.activity.repository
 * Description: 活动仓储接口
 *
 * @Author 张世召
 * @Create 2025/3/15 10:12
 * @Version 1.0
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

}
