package cn.godrel.domain.award.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ClassName: UserCreditAwardEntity
 * Package: cn.godrel.domain.award.model.entity
 * Description: 用户积分奖品实体对象
 *
 * @Author 张世召
 * @Create 2025/5/14 17:28
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreditAwardEntity {
    // 用户ID
    private String userId;
    // 积分值
    private BigDecimal creditAmount;
}
