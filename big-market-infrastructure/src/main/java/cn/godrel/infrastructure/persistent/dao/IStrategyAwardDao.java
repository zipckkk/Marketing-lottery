package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.Award;
import cn.godrel.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: IStrategyAwardDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description:
 *
 * @Author 张世召
 * @Create 2025/2/24 15:07
 * @Version 1.0
 */
@Mapper
public interface IStrategyAwardDao {

    List<StrategyAward> queryStrategyAwardList();

    List<StrategyAward> queryStrategyAwardListByStrategyId(Long strategyId);

    String queryStrategyAwardRuleModels(StrategyAward strategyAward);

    void updateStrategyAwardStock(StrategyAward strategyAward);
}
