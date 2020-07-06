package com.radebit.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Rade
 * @date 2020/7/5 8:09 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/zk")
    public String paymentZk() {
        return "SpringCloud with zookeeper:" + port + "\t" + UUID.randomUUID().toString();
    }
}
