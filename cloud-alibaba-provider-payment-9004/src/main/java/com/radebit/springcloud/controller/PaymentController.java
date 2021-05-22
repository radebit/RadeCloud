package com.radebit.springcloud.controller;

import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author Rade
 * @Date 2021/5/20 15:29:29
 * @Description
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 说明：这边是为了方便演示，没有使用数据库！
     */
    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "serial-01"));
        hashMap.put(2L, new Payment(2L, "serial-02"));
        hashMap.put(3L, new Payment(3L, "serial-03"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return new CommonResult<>(200, "success,serverPort=" + serverPort, hashMap.get(id));
    }
}
