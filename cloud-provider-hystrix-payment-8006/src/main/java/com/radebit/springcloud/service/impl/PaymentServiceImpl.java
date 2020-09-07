package com.radebit.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.radebit.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk,id：" + id + "\t SUCCESS";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })   // 出问题后兜底的方法
    public String paymentInfoTimeout(Integer id) {
        int timeNum = 3;
//        int errorTest = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoTimeout,id：" + id + "\t TIMEOUT " + " 耗时：" + timeNum + "秒";
    }

    /**
     * paymentInfoTimeout的fallback方法
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoTimeoutHandler,id：" + id + "\t 系统繁忙，请稍后再试！";
    }
}
