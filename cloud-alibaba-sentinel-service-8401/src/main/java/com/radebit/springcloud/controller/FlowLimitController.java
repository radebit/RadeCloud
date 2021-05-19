package com.radebit.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey p1=" + p1 + ",p2=" + p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException) {
        return "testHotKey出现异常";
    }
}
