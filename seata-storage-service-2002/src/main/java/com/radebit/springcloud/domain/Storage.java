package com.radebit.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Rade
 * @Date 2021/5/22 11:45:45
 * @Description 
 */
/**
    * 库存表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    /**
    * 库存ID
    */
    private Long storageId;

    /**
    * 产品ID
    */
    private Long productId;

    /**
    * 总库存
    */
    private Integer totalNum;

    /**
    * 已扣库存
    */
    private Integer usedNum;

    /**
    * 剩余库存
    */
    private Integer redidueNum;
}