package com.radebit.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Rade
 * @Date 2021/5/22 10:12:12
 * @Description
 */
@Configuration
@MapperScan({"com.radebit.springcloud.mapper"})
public class MyBatisConfig {
}
