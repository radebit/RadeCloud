package com.radebit.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;
import com.radebit.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2021/5/20 13:20:20
 * @Description
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<Payment>(200, "按资源名限流测试成功", new Payment(2021L, "serial-001"));
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<Payment>(200, "按Url限流测试成功", new Payment(2022L, "serial-002"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(
            value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerExceptionF2"
    )
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<Payment>(200, "customerBlockHandler限流测试成功", new Payment(2023L, "serial-003"));
    }

    public CommonResult<String> handleException(BlockException blockException) {
        return new CommonResult<String>(503, blockException.getClass().getCanonicalName() + "\t 服务不可用");
    }
}
