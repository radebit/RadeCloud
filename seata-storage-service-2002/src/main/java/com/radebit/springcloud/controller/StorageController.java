package com.radebit.springcloud.controller;

import com.radebit.springcloud.entities.CommonResult;
import com.radebit.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2021/5/22 11:21:21
 * @Description
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/decrease")
    public CommonResult<Integer> createOrder(@RequestParam("productId") Long productId,
                                             @RequestParam("count") Integer count) {
        if (storageService.decrease(productId, count) == 1) {
            return new CommonResult<>(200, "扣减库存成功", 1);
        }
        return new CommonResult<>(500, "扣减库存失败", -1);
    }
}
