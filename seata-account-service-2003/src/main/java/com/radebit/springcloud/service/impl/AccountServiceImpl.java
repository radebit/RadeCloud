package com.radebit.springcloud.service.impl;

import com.radebit.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.radebit.springcloud.domain.Account;
import com.radebit.springcloud.mapper.AccountMapper;

import java.math.BigDecimal;

/**
 * @Author Rade
 * @Date 2021/5/22 12:11:11
 * @Description
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return accountMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(Account record) {
        return accountMapper.insert(record);
    }

    @Override
    public int insertSelective(Account record) {
        return accountMapper.insertSelective(record);
    }

    @Override
    public Account selectByPrimaryKey(Long userId) {
        return accountMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return accountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Account record) {
        return accountMapper.updateByPrimaryKey(record);
    }

    /**
     * 扣减余额
     */
    @Override
    public int decrease(Long userId, BigDecimal money) {
        log.info("===== account-service 扣减余额开始 =====");
        Account account = selectByPrimaryKey(userId);
        if (account == null) {
            throw new RuntimeException("用户不存在！");
        }
        account.setUsedMoney(account.getUsedMoney().add(money));
        account.setResidueMoney(account.getTotalMoney().subtract(account.getUsedMoney()));
        int res = updateByPrimaryKeySelective(account);
        log.info("===== account-service 扣减余额结束 =====");
        return res;
    }
}

