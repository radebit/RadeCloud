package com.radebit.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rade
 * @date 2020/7/25 4:31 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@Configuration
public class FeignConfig {
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
