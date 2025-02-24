package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.Strategy;
import cn.godrel.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: IStrategyDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description:抽奖策略
 * @Author 张世召
 * @Create 2025/2/24 14:22
 * @Version 1.0
 */
@Mapper
public interface IStrategyDao {

    List<Strategy> queryStrategyList();
}
