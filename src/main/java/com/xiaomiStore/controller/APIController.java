package com.xiaomiStore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class APIController {
    //用户列表
    @RequestMapping("/api/users")
    public Map<String, Object> getUsers(){

    }
    //产品列表
    @RequestMapping("/api/products")
    public Map<String, Object> getProducts(){

    }
    //轮播列表
    @RequestMapping("/api/loopDisplay")
    public Map<String, Object> getLoopDisplay(){

    }
    //优惠券列表
    @RequestMapping("/api/coupons")
    public Map<String, Object> getCoupons(){

    }
}
