package com.radebit.springcloud.service;

import com.radebit.springcloud.domain.Account;

import java.math.BigDecimal;

/**
 * @Author Rade
 * @Date 2021/5/22 12:12:12
 * @Description
 */
public interface AccountService {
    int deleteByPrimaryKey(Long userId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    /**
     * 扣减余额
     */
    int decrease(Long userId, BigDecimal money);
}
