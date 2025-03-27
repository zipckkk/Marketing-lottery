package cn.godrel.api;

import cn.godrel.api.dto.*;
import cn.godrel.types.model.Response;

import java.util.List;

/**
 * ClassName: IRaffleService
 * Package: cn.godrel.api
 * Description: 抽奖服务接口
 *
 * @Author 张世召
 * @Create 2025/3/13 11:35
 * @Version 1.0
 */
public interface IRaffleStrategyService {

    /**
     * 策略装配接口
     *
     * @param strategyId 策略ID
     * @return 装配接口
     */
    Response<Boolean> strategyArmory(Long strategyId);

    /**
     * 查询奖品列表配置
     *
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @return 奖品列表数据
     */
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);

    /**
     * 查询抽奖策略权重规则，给用户展示出抽奖N次后必中奖奖品范围
     *
     * @param request 请求对象
     * @return 权重奖品配置列表「这里会返回全部，前端可按需展示一条已达标的，或者一条要达标的」
     */
    Response<List<RaffleStrategyRuleWeightResponseDTO>> queryRaffleStrategyRuleWeight(RaffleStrategyRuleWeightRequestDTO request);

    /**
     * 随机抽奖接口
     *
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleStrategyResponseDTO> randomRaffle(RaffleStrategyRequestDTO requestDTO);
}
