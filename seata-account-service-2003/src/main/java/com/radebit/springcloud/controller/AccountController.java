package com.radebit.springcloud.controller;

import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author Rade
 * @Date 2021/5/22 11:21:21
 * @Description
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/decrease")
    public CommonResult<Integer> createOrder(@RequestParam("userId") Long userId,
                                             @RequestParam("money") BigDecimal money) {
        if (accountService.decrease(userId, money) == 1) {
            return new CommonResult<>(200, "扣减库存成功", 1);
        }
        return new CommonResult<>(500, "扣减库存失败", -1);
    }
}
