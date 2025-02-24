package cn.godrel.infrastructure.persistent.po;

import lombok.Data;

/**
 * ClassName: Award
 * Package: cn.godrel.infrastructure.persistent.po
 * Description:奖品
 * @Author 张世召
 * @Create 2025/2/24 14:15
 * @Version 1.0
 */
@Data
public class Award {

    private String id;
    //自增ID

    private String awardId;
    //抽奖奖品ID - 内部流转使用

    private String awardKey;
    //奖品对接标识 - 每一个都是一个对应的发奖策略

    private String awardConfig;
    //奖品配置信息

    private String awardDesc;
    //奖品内容描述

    private String createTime;
    //创建时间

    private String updateTime;
    //更新时间
}
