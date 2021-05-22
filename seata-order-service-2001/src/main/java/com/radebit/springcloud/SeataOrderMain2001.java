package com.radebit.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Rade
 * @Date 2021/5/21 23:41:41
 * @Description
 */
@EnableFeignClients
@EnableDiscoveryClient
//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源自动创建
//@MapperScan({"com.radebit.springcloud.mapper"})
public class SeataOrderMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2001.class, args);
    }
}
