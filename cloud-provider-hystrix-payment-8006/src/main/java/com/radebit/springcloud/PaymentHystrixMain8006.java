package com.radebit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Rade
 * @date 2020/8/7 3:37 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8006.class, args);
    }
}
