package cn.godrel.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: RaffleActivityCount
 * Package: cn.godrel.infrastructure.persistent.po
 * Description:抽奖活动次数配置表 持久化对象
 *
 * @Author 张世召
 * @Create 2025/3/14 11:35
 * @Version 1.0
 */
@Data
public class RaffleActivityCount {
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 活动次数编号
     */
    private Long activityCountId;

    /**
     * 总次数
     */
    private Integer totalCount;

    /**
     * 日次数
     */
    private Integer dayCount;

    /**
     * 月次数
     */
    private Integer monthCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
