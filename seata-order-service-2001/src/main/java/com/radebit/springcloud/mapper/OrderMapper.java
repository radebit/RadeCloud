package com.radebit.springcloud.mapper;

import com.radebit.springcloud.domain.Order;

/**
 * @Author Rade
 * @Date 2021/5/22 00:14:14
 * @Description 
 */
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}