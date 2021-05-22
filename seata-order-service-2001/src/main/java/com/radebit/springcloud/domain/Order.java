package com.radebit.springcloud.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Rade
 * @Date 2021/5/22 00:14:14
 * @Description 订单表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
    * 订单ID
    */
    private Long orderId;

    /**
    * 用户ID
    */
    private Long userId;

    /**
    * 产品ID
    */
    private Long productId;

    /**
    * 数量
    */
    private Integer count;

    /**
    * 金额
    */
    private BigDecimal money;

    /**
    * 订单状态
     * 0-未完成
     * 1-已完成
    */
    private Integer status;
}