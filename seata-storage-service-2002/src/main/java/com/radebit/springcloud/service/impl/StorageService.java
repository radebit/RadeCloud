package com.radebit.springcloud.service.impl;

import com.radebit.springcloud.domain.Storage;
    /**
 * @Author Rade
 * @Date 2021/5/22 11:45:45
 * @Description 
 */
public interface StorageService{


    int deleteByPrimaryKey(Long storageId);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Long storageId);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

}
