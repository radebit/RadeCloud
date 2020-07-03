package com.radebit.springcloud.service;

import com.radebit.springcloud.entities.Payment;
public interface PaymentService{


    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

}
