package cn.godrel.infrastructure.persistent.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName: UserCreditAccount
 * Package: cn.godrel.infrastructure.persistent.po
 * Description:
 *
 * @Author 张世召
 * @Create 2025/5/14 17:02
 * @Version 1.0
 */
@Data
public class UserCreditAccount {
    /** 自增ID */
    private Long id;
    /** 用户ID */
    private String userId;
    /** 总积分，显示总账户值，记得一个人获得的总积分 */
    private BigDecimal totalAmount;
    /** 可用积分，每次扣减的值 */
    private BigDecimal availableAmount;
    /** 账户状态【open - 可用，close - 冻结】 */
    private String accountStatus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
