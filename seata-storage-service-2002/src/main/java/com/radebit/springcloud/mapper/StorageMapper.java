package com.radebit.springcloud.mapper;
import org.apache.ibatis.annotations.Param;

import com.radebit.springcloud.domain.Storage;

/**
 * @Author Rade
 * @Date 2021/5/22 11:45:45
 * @Description 
 */
public interface StorageMapper {
    int deleteByPrimaryKey(Long storageId);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Long storageId);

    Storage selectByProductId(@Param("productId")Long productId);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}