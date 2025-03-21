package cn.godrel.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: RaffleActivityAccountMonth
 * Package: cn.godrel.infrastructure.persistent.po
 * Description: 奖活动账户表-月次数
 *
 * @Author 张世召
 * @Create 2025/3/17 17:42
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleActivityAccountMonth {

    private final SimpleDateFormat dateFormatMonth = new SimpleDateFormat("yyyy-MM");

    /** 自增ID */
    private String id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 月（yyyy-mm） */
    private String month;
    /** 月次数 */
    private Integer monthCount;
    /** 月次数-剩余 */
    private Integer monthCountSurplus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public String currentMonth() {
        return dateFormatMonth.format(new Date());
    }
}
