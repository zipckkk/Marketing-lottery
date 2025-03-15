package cn.godrel.domain.activity.service;

import cn.godrel.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * ClassName: RaffleActivityService
 * Package: cn.godrel.domain.activity.service
 * Description: 抽奖活动服务
 *
 * @Author 张世召
 * @Create 2025/3/15 11:12
 * @Version 1.0
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity{

    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }
}
