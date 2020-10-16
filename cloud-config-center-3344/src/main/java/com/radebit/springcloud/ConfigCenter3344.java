package com.radebit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Rade
 * @date 2020/10/9 4:04 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class, args);
    }
}
