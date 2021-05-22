package com.radebit.springcloud.controller;

import com.radebit.springcloud.domain.Order;
import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2021/5/22 11:21:21
 * @Description
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public CommonResult<Order> createOrder(@RequestBody Order order) {
        if (orderService.createOrder(order) == 1) {
            return new CommonResult<>(200, "创建订单成功", order);
        }
        return new CommonResult<>(500, "创建订单失败", null);
    }
}
