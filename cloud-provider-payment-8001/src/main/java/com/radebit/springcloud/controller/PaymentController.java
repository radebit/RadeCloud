package com.radebit.springcloud.controller;

import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.entities.Payment;
import com.radebit.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        if (payment != null) {
            return new CommonResult(200, "获取成功！", payment);
        } else {
            return new CommonResult(-1, "数据不存在！");
        }
    }

    @PostMapping()
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("===插入结果：" + result + "===");

        if (result > 0) {
            return new CommonResult(200, "插入成功！", result);
        } else {
            return new CommonResult(-1, "插入失败！");
        }
    }
}
