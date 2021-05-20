package com.radebit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Rade
 * @Date 2021/5/20 19:46:46
 * @Description
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNaocsMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNaocsMain84.class, args);
    }
}
