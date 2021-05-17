package com.radebit.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2021/5/17 22:46:46
 * @Description
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "===== TestA =====";
    }

    @GetMapping("/testB")
    public String testB() {
        return "===== TestB =====";
    }

    @GetMapping("/testC")
    public String testC() {
        return "===== TestC =====";
    }
}
