package com.radebit.springcloud.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Rade
 * @Date 2021/5/22 12:12:12
 * @Description 
 */

/**
 * 账户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal totalMoney;

    /**
     * 已用额度
     */
    private BigDecimal usedMoney;

    /**
     * 剩余可用额度
     */
    private BigDecimal residueMoney;
}