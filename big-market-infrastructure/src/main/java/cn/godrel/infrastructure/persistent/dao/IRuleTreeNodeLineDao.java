package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: IRuleTreeNodeLineDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 规则树节点连线表DAO
 *
 * @Author 张世召
 * @Create 2025/3/8 17:19
 * @Version 1.0
 */
@Mapper
public interface IRuleTreeNodeLineDao {
    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);
}
