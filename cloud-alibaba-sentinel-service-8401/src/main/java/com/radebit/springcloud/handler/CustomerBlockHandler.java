package com.radebit.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;

/**
 * @Author Rade
 * @Date 2021/5/20 13:40:40
 * @Description
 */
public class CustomerBlockHandler {
    public static CommonResult<Payment> handlerExceptionF1(BlockException blockException) {
        return new CommonResult<>(503, "客户自定义,global-F1", new Payment(2021L, "serial-003"));
    }

    public static CommonResult<Payment> handlerExceptionF2(BlockException blockException) {
        return new CommonResult<>(503, "客户自定义,global-F2", new Payment(2022L, "serial-004"));
    }
}
