package cn.godrel.api;

import cn.godrel.api.dto.RaffleAwardListRequestDTO;
import cn.godrel.api.dto.RaffleAwardListResponseDTO;
import cn.godrel.api.dto.RaffleRequestDTO;
import cn.godrel.api.dto.RaffleResponseDTO;
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
public interface IRaffleService {

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
     * 随机抽奖接口
     *
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleResponseDTO> randomRaffle(RaffleRequestDTO requestDTO);


}
