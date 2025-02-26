package cn.godrel.domain.strategy.service.armory;

import cn.godrel.domain.strategy.model.entity.StrategyAwardEntity;
import cn.godrel.domain.strategy.repository.IStrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: StrategyArmory
 * Package: cn.godrel.domain.strategy.service.armory
 * Description:负责初始化策略计算
 *
 * @Author 张世召
 * @Create 2025/2/25 19:31
 * @Version 1.0
 */
@Slf4j
@Service
public class StrategyArmory implements IStrategyArmory {

    @Resource
    private IStrategyRepository repository;

    @Override
    public void assembleLotteryStrategy(Long strategyId) {
        //1. 查询策略配置
        List<StrategyAwardEntity> strategyAwardEntities = repository.queryStrategyAwardList(strategyId);

        //2. 获取最小值概率值，比如 0.001
        BigDecimal minAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        //3. 获取概率值总和，应该等于1
        BigDecimal totalAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //4. 用 1 % 0.0001 获取概率范围，百分位、千分位、万分位
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.CEILING);

        /*
        * 5. 按概率比例将奖项ID填充到查找表中
        * 示例：奖项A概率=0.3，rateRange=10000 → 填充3000次。
        * 目的：表中每个位置代表一个“抽奖槽位”，高概率奖项占据更多槽位。
        * */
        ArrayList<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue()); //构建查找表，10000个格子
        for (StrategyAwardEntity strategyAward : strategyAwardEntities) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();
            /*
            计算出每个概率值需要存储到查找表的数量，循环补充
            * rateRange.multiply(awardRate)          // 计算总槽位数 × 当前奖项概率
                        .setScale(0, RoundingMode.CEILING) // 结果向上取整到整数
                        .intValue();                       // 转换为 int 类型
            **/
            for (int i = 0; i < rateRange.multiply(awardRate).setScale(0,RoundingMode.CEILING).intValue(); i++){
                strategyAwardSearchRateTables.add(awardId);
            }
        }

        //6. 打乱顺序；确保槽位随机分布，避免连续命中同一奖项。
        Collections.shuffle(strategyAwardSearchRateTables);

        //7. 转换成 Map，将列表转换为索引到奖项ID的映射，便于通过随机数直接查询。
        HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables = new HashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTables.size(); i++){
            shuffleStrategyAwardSearchRateTables.put(i, strategyAwardSearchRateTables.get(i));
        }

        //8. 存储到 redis
        repository.storeStrategyAwardSearchRateTables(strategyId, shuffleStrategyAwardSearchRateTables.size(), shuffleStrategyAwardSearchRateTables);
    }

    @Override
    public Integer getRandomAwardId(Long strategyId) {
        int rateRange =repository.getRateRange(strategyId);
        return repository.getStrategyAwardAssemble(strategyId, new SecureRandom().nextInt(rateRange));
    }
}
