package com.radebit.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Rade
 * @date 2020/7/3 12:07 上午
 * @url https://blog.radebit.com
 * 说明：
 */
@SpringBootApplication
@MapperScan({"com.radebit.springcloud.mapper*"})
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
