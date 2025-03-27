package cn.godrel.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: UserActivityAccountResponseDTO
 * Package: cn.godrel.api.dto
 * Description: 用户活动账户应答对象
 *
 * @Author 张世召
 * @Create 2025/3/21 17:09
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserActivityAccountResponseDTO {
    /**
     * 总次数
     */
    private Integer totalCount;

    /**
     * 总次数-剩余
     */
    private Integer totalCountSurplus;

    /**
     * 日次数
     */
    private Integer dayCount;

    /**
     * 日次数-剩余
     */
    private Integer dayCountSurplus;

    /**
     * 月次数
     */
    private Integer monthCount;

    /**
     * 月次数-剩余
     */
    private Integer monthCountSurplus;
}
