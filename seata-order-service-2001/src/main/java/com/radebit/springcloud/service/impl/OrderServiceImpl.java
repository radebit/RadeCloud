package com.radebit.springcloud.service.impl;

import com.radebit.springcloud.constant.OrderStatusConstants;
import com.radebit.springcloud.service.AccountService;
import com.radebit.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.radebit.springcloud.domain.Order;
import com.radebit.springcloud.mapper.OrderMapper;
import com.radebit.springcloud.service.OrderService;

/**
 * @Author Rade
 * @Date 2021/5/22 00:14:14
 * @Description
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public int deleteByPrimaryKey(Long orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) {
        record.setStatus(OrderStatusConstants.NO_OVER);
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    /**
     * 创建订单业务
     */
    @Override
    public int createOrder(Order order) {
        log.info("===== 开始创建新的订单 =====");
        insert(order);

        log.info("===== 订单微服务开始调用库存服务，进行扣减库存 =====");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("===== 订单微服务开始调用账户服务，进行扣减余额 =====");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("===== 修改订单状态开始 =====");
        order.setStatus(OrderStatusConstants.OVER);
        updateByPrimaryKeySelective(order);
        log.info("===== 修改订单状态结束 =====");

        log.info("===== 创建订单结束 =====");
        return 1;
    }
}
