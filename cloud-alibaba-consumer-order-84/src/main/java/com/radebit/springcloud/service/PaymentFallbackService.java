package com.radebit.springcloud.service;

import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author Rade
 * @Date 2021/5/20 23:31:31
 * @Description PaymentService兜底
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new CommonResult<>(503,"服务降级返回：PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
