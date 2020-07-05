package com.radebit.springcloud.service.impl;

import com.radebit.springcloud.entities.Payment;
import com.radebit.springcloud.mapper.PaymentMapper;
import com.radebit.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return paymentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Payment record) {
        return paymentMapper.insert(record);
    }

    @Override
    public int insertSelective(Payment record) {
        return paymentMapper.insertSelective(record);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Payment record) {
        return paymentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Payment record) {
        return paymentMapper.updateByPrimaryKey(record);
    }

}
