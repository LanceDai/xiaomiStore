package com.xiaomiStore.controller;

import com.xiaomiStore.pojo.Attention;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.AttentionService;
import com.xiaomiStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AttentionController {

    private final AttentionService attentionService;
    private final ProductService productService;

    @Autowired
    public AttentionController(AttentionService attentionService, ProductService productService) {
        this.attentionService = attentionService;
        this.productService = productService;
    }

    @RequestMapping(value = "/attention", method = RequestMethod.POST)
    @ResponseBody
    public String changeAttention(@RequestParam("productName")String productName, HttpSession httpSession){
        //判断是否登陆
        User user = (User) httpSession.getAttribute("loginUser");
        if (user == null) {
            System.out.println("未登录");
            return "false";
        }
        //判断数据库是否存在关注的记录
        String userId = user.getUserId();
        String productId = productService.getProductIdByProductName(productName);
        if (attentionService.isExistByUserIdAndProductId(userId, productId) != 0){
            attentionService.delete(userId, productId);
            System.out.println("已关注， 取消关注");
            return "false";
        }
        else {
            attentionService.insert(new Attention(userId, productId));
            System.out.println("未关注， 添加关注");
            return "true";
        }
    }

    @RequestMapping(value = "/attentionStatus", method = RequestMethod.POST)
    @ResponseBody
    public String isAttention(@RequestParam("productName")String productName, HttpSession httpSession){
        //判断是否登陆
        User user = (User) httpSession.getAttribute("loginUser");
        if (user == null) {
            System.out.println("未登录");
            return "false";
        }
        //判断数据库是否存在关注的记录
        String userId = user.getUserId();
        String productId = productService.getProductIdByProductName(productName);
        return attentionService.isExistByUserIdAndProductId(userId, productId) != 0 ? "true" : "false";
    }
}
