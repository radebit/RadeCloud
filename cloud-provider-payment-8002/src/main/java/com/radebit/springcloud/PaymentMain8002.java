package com.radebit.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Rade
 * @date 2020/7/3 12:07 上午
 * @url https://blog.radebit.com
 * 说明：
 */
@SpringBootApplication
@MapperScan({"com.radebit.springcloud.mapper*"})
@EnableEurekaClient // 应用Eureka客户端
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
