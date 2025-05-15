package cn.godrel.domain.award.service.distribute.impl;

import cn.godrel.domain.award.model.aggregate.GiveOutPrizesAggregate;
import cn.godrel.domain.award.model.entity.DistributeAwardEntity;
import cn.godrel.domain.award.model.entity.UserAwardRecordEntity;
import cn.godrel.domain.award.model.entity.UserCreditAwardEntity;
import cn.godrel.domain.award.model.volobj.AwardStateVO;
import cn.godrel.domain.award.repository.IAwardRepository;
import cn.godrel.domain.award.service.IAwardService;
import cn.godrel.domain.award.service.distribute.IDistributeAward;
import cn.godrel.types.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * ClassName: UserCreditRandomAward
 * Package: cn.godrel.domain.award.service.distribute.impl
 * Description: 用户积分奖品，支持 award_config 透传，满足黑名单积分奖励。
 *
 * @Author 张世召
 * @Create 2025/5/14 17:09
 * @Version 1.0
 */
@Component("user_credit_random")
public class UserCreditRandomAward implements IDistributeAward {
    @Resource
    private IAwardRepository awardRepository;

    @Override
    public void giveOutPrize(DistributeAwardEntity distributeAwardEntity) {
        // 奖品ID
        Integer awardId = distributeAwardEntity.getAwardId();
        // 奖品配置
        String awardConfig = distributeAwardEntity.getAwardConfig();

        if(StringUtils.isBlank(awardConfig)){
            awardConfig = awardRepository.queryAwardConfig(awardId);
        }

        String[] creditRange = awardConfig.split(Constants.SPLIT);
        if(creditRange.length != 2){
            throw new RuntimeException("award_config: " + awardConfig + " 不是一个范围值，如 1,100");
        }
        // 生成随机积分
        BigDecimal creditAmount = generateRandom(new BigDecimal(creditRange[0]), new BigDecimal(creditRange[1]));

        // 构建聚合对象
        UserAwardRecordEntity userAwardRecordEntity = GiveOutPrizesAggregate.buildDistributeUserAwardRecordEntity(
                distributeAwardEntity.getUserId(),
                distributeAwardEntity.getOrderId(),
                distributeAwardEntity.getAwardId(),
                AwardStateVO.complete
        );

        UserCreditAwardEntity userCreditAwardEntity = GiveOutPrizesAggregate.buildUserCreditAwardEntity(distributeAwardEntity.getUserId(), creditAmount);

        GiveOutPrizesAggregate giveOutPrizesAggregate = new GiveOutPrizesAggregate();
        giveOutPrizesAggregate.setUserId(distributeAwardEntity.getUserId());
        giveOutPrizesAggregate.setUserAwardRecordEntity(userAwardRecordEntity);
        giveOutPrizesAggregate.setUserCreditAwardEntity(userCreditAwardEntity);

        // 存储发奖对象
        awardRepository.saveGiveOutPrizesAggregate(giveOutPrizesAggregate);

    }

    private BigDecimal generateRandom(BigDecimal min, BigDecimal max) {
        if(min.equals(max)){
            return min;
        }
        /*
        Math.random()生成一个[0, 1)区间的double类型随机数。
        通过BigDecimal.valueOf()将double转换为BigDecimal（注意：此方式可能因double精度问题导致误差）。
        max.subtract(min)计算范围差值，再与随机数相乘，得到一个[0, (max-min))的偏移量。
        最终结果为min + 偏移量，即[min, max)区间的随机数。
        */
        BigDecimal randomBigDecimal = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));
        // 使用MathContext(3)对结果进行四舍五入，保留3位有效数字
        return randomBigDecimal.round(new MathContext(3));
    }
}
