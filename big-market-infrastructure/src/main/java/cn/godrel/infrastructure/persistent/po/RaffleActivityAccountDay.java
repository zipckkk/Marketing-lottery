package cn.godrel.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: RaffleActivityAccountDay
 * Package: cn.godrel.infrastructure.persistent.po
 * Description: 抽奖活动账户表-日次数
 *
 * @Author 张世召
 * @Create 2025/3/17 17:42
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleActivityAccountDay {

    private final SimpleDateFormat dateFormatDay = new SimpleDateFormat("yyyy-MM-dd");

    /** 自增ID */
    private String id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 日期（yyyy-mm-dd） */
    private String day;
    /** 日次数 */
    private Integer dayCount;
    /** 日次数-剩余 */
    private Integer dayCountSurplus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    // 返回当天的日期
    public String currentDay(){
        return dateFormatDay.format(new Date());
    }


}
