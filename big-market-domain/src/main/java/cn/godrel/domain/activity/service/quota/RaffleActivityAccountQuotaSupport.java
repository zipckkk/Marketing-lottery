package cn.godrel.domain.activity.service.quota;

import cn.godrel.domain.activity.model.entity.ActivityCountEntity;
import cn.godrel.domain.activity.model.entity.ActivityEntity;
import cn.godrel.domain.activity.model.entity.ActivitySkuEntity;
import cn.godrel.domain.activity.repository.IActivityRepository;
import cn.godrel.domain.activity.service.quota.rule.factory.DefaultActivityChainFactory;

/**
 * ClassName: RaffleActivitySupport
 * Package: cn.godrel.domain.activity.service
 * Description:
 *
 * @Author 张世召
 * @Create 2025/3/15 16:42
 * @Version 1.0
 */
public class RaffleActivityAccountQuotaSupport {


    protected IActivityRepository activityRepository;

    protected DefaultActivityChainFactory defaultActivityChainFactory;

    public RaffleActivityAccountQuotaSupport(IActivityRepository activityRepository, DefaultActivityChainFactory defaultActivityChainFactory) {
        this.activityRepository = activityRepository;
        this.defaultActivityChainFactory = defaultActivityChainFactory;
    }

    public ActivitySkuEntity queryActivitySku(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }





}
