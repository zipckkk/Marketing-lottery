package cn.godrel.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: RuleTree
 * Package: cn.godrel.infrastructure.persistent.po
 * Description: 规则树
 *
 * @Author 张世召
 * @Create 2025/3/8 17:14
 * @Version 1.0
 */
@Data
public class RuleTree {
    /** 自增ID */
    private Long id;
    /** 规则树ID */
    private String treeId;
    /** 规则树名称 */
    private String treeName;
    /** 规则树描述 */
    private String treeDesc;
    /** 规则根节点 */
    private String treeRootRuleKey;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
