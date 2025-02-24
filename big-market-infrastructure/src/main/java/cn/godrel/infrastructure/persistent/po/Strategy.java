package cn.godrel.infrastructure.persistent.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * ClassName: Strategy
 * Package: cn.godrel.infrastructure.persistent.po
 * Description:抽奖策略
 * @Author 张世召
 * @Create 2025/2/24 13:36
 * @Version 1.0
 */
@Data
public class Strategy {

    //自增ID
    private Long id;
    //抽奖策略ID
    private String strategyId;
    //抽奖策略描述
    private String strategyDesc;
    //创建时间
    private String updateTime;
    //更新时间
    private String createTime;

}
