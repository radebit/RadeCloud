package com.radebit.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2021/5/22 11:21:21
 * @Description
 */
@RestController
@RequestMapping("/account")
public class AccountController {
//    @Autowired
//    private StorageService storageService;
//
//    @PostMapping("/decrease")
//    public CommonResult<Integer> createOrder(@RequestParam("productId") Long productId,
//                                             @RequestParam("count") Integer count) {
//        if (storageService.decrease(productId, count) == 1) {
//            return new CommonResult<>(200, "扣减库存成功", 1);
//        }
//        return new CommonResult<>(500, "扣减库存失败", -1);
//    }
}
