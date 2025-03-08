package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRuleTreeDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 规则树表DAO
 *
 * @Author 张世召
 * @Create 2025/3/8 17:17
 * @Version 1.0
 */
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);
}
