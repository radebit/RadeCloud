package com.radebit.springcloud.service;

import com.radebit.springcloud.domain.Storage;

/**
 * @Author Rade
 * @Date 2021/5/22 11:42:42
 * @Description
 */
public interface StorageService {


    int deleteByPrimaryKey(Long storageId);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Long storageId);

    Storage selectByProductId(Long productId);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    /**
     * 扣减库存
     */
    int decrease(Long productId,Integer count);
}
