package com.radebit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Rade
 * @Date 2021/5/20 19:46:46
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNaocsMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNaocsMain84.class, args);
    }
}
