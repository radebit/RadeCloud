package com.radebit.springcloud.service;

import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Rade
 * @date 2020/7/21 10:30 上午
 * @url https://blog.radebit.com
 * 说明：
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @PostMapping("/payment")
    CommonResult<Integer> create(Payment payment);

    @GetMapping("/payment/{id}")
    CommonResult<Payment> selectPaymentById(@PathVariable("id")Long id);

    @GetMapping("/payment/timeout")
    CommonResult<String> timeout();
}
