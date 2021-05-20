package com.radebit.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Rade
 * @Date 2021/5/20 22:00:00
 * @Description
 */
@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常！");
        }
        CommonResult<Payment> result = restTemplate.getForObject(serverUrl + "/payment/" + id, CommonResult.class, id);
        if (result.getData() == null) {
            throw new NullPointerException("NullPointerException，该ID没有对应记录，空指针异常！");
        }
        return result;
    }
}
