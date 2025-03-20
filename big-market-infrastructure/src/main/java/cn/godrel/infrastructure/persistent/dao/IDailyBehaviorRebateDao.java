package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.DailyBehaviorRebate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: IDailyBehaviorRebateDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 日常行为返利活动配置
 *
 * @Author 张世召
 * @Create 2025/3/19 22:28
 * @Version 1.0
 */
@Mapper
public interface IDailyBehaviorRebateDao {
    List<DailyBehaviorRebate> queryDailyBehaviorRebateByBehaviorType(String behaviorType);
}
