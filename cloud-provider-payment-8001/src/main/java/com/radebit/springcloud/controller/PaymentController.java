package com.radebit.springcloud.controller;

import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;
import com.radebit.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Rade
 * @date 2020/7/3 1:23 上午
 * @url https://blog.radebit.com
 * 说明：
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;    // 对于注册进入Eureka的微服务，可以通过服务发现来获得改服务的信息

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public CommonResult<Integer> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        if (payment != null) {
            return new CommonResult(200, "获取成功！port:" + serverPort, payment);
        } else {
            return new CommonResult(-1, "数据不存在！port:" + serverPort);
        }
    }

    @PostMapping()
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("===插入结果：" + result + "===");

        if (result > 0) {
            return new CommonResult(200, "插入成功！port:" + serverPort, result);
        } else {
            return new CommonResult(-1, "插入失败！port:" + serverPort);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("====element===>" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("====instance===>" + instance.getServiceId() + "\t"
                    + instance.getHost() + "\t"
                    + instance.getPort() + "\t"
                    + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "success payment for zipkin!";
    }
}
