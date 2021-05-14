package com.radebit.springcloud.controller;

import com.radebit.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Rade
 * @Date 2021/5/14 14:40:40
 * @Description
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/send")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
