package cn.godrel.domain.activity.model.entity;

import cn.godrel.domain.activity.model.valobj.ActivityStateVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: ActivityEntity
 * Package: cn.godrel.domain.activity.model.entity
 * Description: 活动实体对象
 *
 * @Author 张世召
 * @Create 2025/3/15 10:15
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityEntity {
    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 开始时间
     */
    private Date beginDateTime;

    /**
     * 结束时间
     */
    private Date endDateTime;

    /**
     * 活动参与次数配置
     */
    private Long activityCountId;

    /**
     * 抽奖策略ID
     */
    private Long strategyId;

    /**
     * 活动状态
     */
    private ActivityStateVO state;

}
