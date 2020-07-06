package com.radebit.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rade
 * @date 2020/7/3 2:42 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
