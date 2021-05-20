package com.radebit.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
//    @SentinelResource(value = "fallback")   // 没有任何配置的情况
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")  // fallback只负责处理业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")  // blockHandler只负责处理限流
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")  // 都配置
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})  // 排除
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

    // handlerFallback
    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable throwable) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(503, "fallback异常兜底，exception：" + throwable.getMessage(), payment);
    }

    // blockHandler
    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(500, "blockHandler-Sentinel限流，blockException：" + blockException.getMessage(), payment);
    }
}
