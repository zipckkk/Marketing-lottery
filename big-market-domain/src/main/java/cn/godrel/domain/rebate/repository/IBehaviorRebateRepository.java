package cn.godrel.domain.rebate.repository;

import cn.godrel.domain.rebate.model.aggregate.BehaviorRebateAggregate;
import cn.godrel.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import cn.godrel.domain.rebate.model.valobj.BehaviorTypeVO;
import cn.godrel.domain.rebate.model.valobj.DailyBehaviorRebateVO;

import java.util.List;

/**
 * ClassName: IBehaviorRebateRepository
 * Package: cn.godrel.domain.rebate.repository
 * Description: 行为返利服务仓储接口
 *
 * @Author 张世召
 * @Create 2025/3/20 14:59
 * @Version 1.0
 */
public interface IBehaviorRebateRepository {
    void saveUserRebateRecord(String userId, List<BehaviorRebateAggregate> behaviorRebateAggregates);

    List<DailyBehaviorRebateVO> queryDailyBehaviorRebateConfig(BehaviorTypeVO behaviorTypeVO);

    List<BehaviorRebateOrderEntity> queryOrderByOutBusinessNo(String userId, String outBusinessNo);
}
