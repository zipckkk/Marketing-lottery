package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRaffleActivityDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description:抽奖活动表Dao
 *
 * @Author 张世召
 * @Create 2025/3/14 14:43
 * @Version 1.0
 */
@Mapper
public interface IRaffleActivityDao {
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

    Long queryStrategyIdByActivityId(Long activityId);

    Long queryActivityIdByStrategyId(Long strategyId);
}
