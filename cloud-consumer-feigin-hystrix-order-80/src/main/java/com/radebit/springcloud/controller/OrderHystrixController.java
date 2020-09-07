package com.radebit.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.radebit.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Rade
 * @date 2020/7/21 10:39 上午
 * @url https://blog.radebit.com
 * 说明：
 */
@RestController
@Slf4j
@RequestMapping("/orderHystrix")
@DefaultProperties(defaultFallback = "paymentGlobalCommonFallback") // 默认的fallback方法
public class OrderHystrixController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })   // 出问题后兜底的方法
    @HystrixCommand // 使用默认fallback
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
//        int errorTest = 10 / 0; // 报错测试
        return paymentFeignService.paymentInfoTimeout(id);
    }

    /**
     * paymentInfoTimeout的fallback方法
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        // 当前服务不可用了，做服务降级，兜底方案都是paymentInfoTimeoutHandler
        return "客户端80发现对方服务系统繁忙或自己服务运行出错！";
    }

    /**
     * 全局fallback
     *
     * @return
     */
    public String paymentGlobalCommonFallback() {
        return "全局异常处理信息，请稍后再试！";
    }

}
