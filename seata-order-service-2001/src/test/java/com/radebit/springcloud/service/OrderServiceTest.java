package com.radebit.springcloud.service;

import java.math.BigDecimal;

import com.radebit.springcloud.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Rade
 * @Date 2021/5/22 00:18:18
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void insert() {
        Order order = new Order();
        order.setUserId(1L);
        order.setProductId(1L);
        order.setCount(1);
        order.setMoney(new BigDecimal("10"));
        order.setStatus(0);
        orderService.insert(order);
    }

    @Test
    void selectByPrimaryKey() {
    }
}