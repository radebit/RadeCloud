package com.radebit.springcloud.service.impl;

import com.radebit.springcloud.service.AccountService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.radebit.springcloud.domain.Account;
import com.radebit.springcloud.mapper.AccountMapper;

/**
 * @Author Rade
 * @Date 2021/5/22 12:11:11
 * @Description
 */
@Service
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

}

