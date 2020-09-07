package com.radebit.springcloud.service.fallback;

import com.radebit.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author Rade
 * @date 2020/9/7 1:50 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "===PaymentFallbackService=== fallback paymentInfoOk，请稍后再试！";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "===PaymentFallbackService=== fallback paymentInfoTimeout，请稍后再试！";
    }
}
