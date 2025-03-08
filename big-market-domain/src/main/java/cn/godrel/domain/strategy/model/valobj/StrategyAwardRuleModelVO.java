package cn.godrel.domain.strategy.model.valobj;

import cn.godrel.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: StrategyAwardRuleModelVO
 * Package: cn.godrel.domain.strategy.model.valobj
 * Description: 抽奖策略规则规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @Author 张世召
 * @Create 2025/3/3 15:27
 * @Version 1.0
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {

    private String ruleModels;

}
