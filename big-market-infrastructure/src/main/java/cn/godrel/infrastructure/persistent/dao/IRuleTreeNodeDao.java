package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: IRuleTreeNodeDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 规则树节点表DAO
 *
 * @Author 张世召
 * @Create 2025/3/8 17:18
 * @Version 1.0
 */
@Mapper
public interface IRuleTreeNodeDao {
    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);
}
