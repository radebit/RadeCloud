package com.radebit.springcloud.service;

public interface PaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeout(Integer id);
}
