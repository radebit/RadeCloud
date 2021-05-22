package com.radebit.springcloud.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.radebit.springcloud.mapper.StorageMapper;
import com.radebit.springcloud.domain.Storage;
import com.radebit.springcloud.service.StorageService;

/**
 * @Author Rade
 * @Date 2021/5/22 11:42:42
 * @Description
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public int deleteByPrimaryKey(Long storageId) {
        return storageMapper.deleteByPrimaryKey(storageId);
    }

    @Override
    public int insert(Storage record) {
        return storageMapper.insert(record);
    }

    @Override
    public int insertSelective(Storage record) {
        return storageMapper.insertSelective(record);
    }

    @Override
    public Storage selectByPrimaryKey(Long storageId) {
        return storageMapper.selectByPrimaryKey(storageId);
    }

    @Override
    public Storage selectByProductId(Long productId) {
        return storageMapper.selectByProductId(productId);
    }

    @Override
    public int updateByPrimaryKeySelective(Storage record) {
        return storageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Storage record) {
        return storageMapper.updateByPrimaryKey(record);
    }

    /**
     * 扣减库存
     */
    @Override
    public int decrease(Long productId, Integer count) {
        Storage storage = selectByProductId(productId);
        if (storage == null) {
            throw new RuntimeException("商品不存在！");
        }
        storage.setUsedNum(storage.getUsedNum() + count);
        storage.setRedidueNum(storage.getTotalNum() - storage.getUsedNum());
        return updateByPrimaryKeySelective(storage);
    }

}
