package cn.godrel.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: RuleTreeNodeLine
 * Package: cn.godrel.infrastructure.persistent.po
 * Description: 规则树节点线[from -> to]
 *
 * @Author 张世召
 * @Create 2025/3/8 17:16
 * @Version 1.0
 */
@Data
public class RuleTreeNodeLine {

    /** 自增ID */
    private Long id;
    /** 规则树ID */
    private String treeId;
    /** 规则Key节点 From */
    private String ruleNodeFrom;
    /** 规则Key节点 To */
    private String ruleNodeTo;
    /** 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围] */
    private String ruleLimitType;
    /** 限定值（到下个节点） */
    private String ruleLimitValue;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
