package com.job.mapper;

import com.job.entity.UserMoney;
import com.job.entity.UserMoneyDetails;
import com.job.entity.vo.JobVo;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author keith
 * @version 1.0
 * @date 2019/11/10
 */
@Repository
public interface UserMoneyMapper {

    /**
     * 查询用户账号信息
     * @param userId 用户id
     * @return
     */
    UserMoney selectById(Integer userId);

    /**
     * 插入用户账户信息
     * @param userId 用户id
     * @return
     */
    int insertMoney(Integer userId);

    /**
     * 更新用户账户信息
     * @param userMoney 用户账户信息
     * @return
     */
    int updateMoney(UserMoney userMoney);

    /**
     * 更新系统账户余额
     * @param money
     * @return
     */
    int updateAdmin(BigDecimal money);

    /**
     * 插入明细
     * @param userMoneyDetails
     * @return
     */
    int insertMoneyDetails(UserMoneyDetails userMoneyDetails);

    /**
     * 查询所有用户账户明细
     * @param userId
     * @return
     */
    List<UserMoneyDetails> findAll(Integer userId);

    /**
     * 统计用户邀请奖励
     * @param userId
     * @return
     */
    BigDecimal countInvite(Integer userId);

    /**
     * 查询系统账户余额
     * @return
     */
    BigDecimal money();
}
