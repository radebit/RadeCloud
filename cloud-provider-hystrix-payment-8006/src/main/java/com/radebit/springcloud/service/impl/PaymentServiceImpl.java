package com.radebit.springcloud.service.impl;

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
    public String paymentInfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok,id：" + id + "\t SUCCESS";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_timeout(Integer id) {
        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeout,id：" + id + "\t TIMEOUT " + " 耗时：" + timeNum + "秒";
    }
}
