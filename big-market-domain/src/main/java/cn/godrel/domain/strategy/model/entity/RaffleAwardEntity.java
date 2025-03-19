package cn.godrel.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: RaffleAwardEntity
 * Package: cn.godrel.domain.strategy.model.entity
 * Description: 抽奖奖品实体
 * @Author 张世召
 * @Create 2025/2/28 15:05
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardEntity {


    //抽奖奖品ID
    private Integer awardId;
    //奖品配置信息
    private String awardConfig;
    //奖品顺序号
    private Integer sort;
    /** 奖品标题（名称） */
    private String awardTitle;

}
