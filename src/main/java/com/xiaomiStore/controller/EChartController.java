package com.xiaomiStore.controller;

import com.google.gson.Gson;
import com.xiaomiStore.service.AttentionService;
import com.xiaomiStore.service.OrderService;
import com.xiaomiStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/echart")
public class EChartController {

    private final AttentionService attentionService;
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public EChartController(AttentionService attentionService, UserService userService, OrderService orderService) {
        this.attentionService = attentionService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/productAttentionStatus", produces = "html/text;charset=UTF-8")
    @ResponseBody
    public String productAttentionStatus() {
        //从数据库得到数据
        List<Map<String, String>> list = attentionService.selectAttentionProductNameAndNumber();
        //对所得到的记录进行切割，取最新的十个记录
        if (list.size() > 10) {
            list = list.subList(0, 10);
        }
        //构造Gson对象，用于将任意对象转换成json字段
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @RequestMapping(value = "/productAttentionStatusView")
    public String productAttentionStatusView() {
        return "productAttentionStatusView";
    }

    @RequestMapping(value = "/userNumberIncreaseStatus", produces = "html/text;charset=UTF-8")
    @ResponseBody
    public String userNumberIncreaseStatus() {
        List<Map<String, String>> map = userService.selectUserStatus();
        Gson gson = new Gson();
        gson.toJson(map);
        System.out.println(gson.toJson(map));
        return gson.toJson(map);
    }

    @RequestMapping(value = "/userNumberIncreaseStatusView")
    public String userNumberIncreaseStatusView() {
        return "userNumberIncreaseStatusView";
    }

    @RequestMapping(value = "/mallProfitFluctuating", produces = "html/text;charset=UTF-8")
    @ResponseBody
    public String mallProfitFluctuating() {
        List<Map<String, String>> list = orderService.selectTimeAndPrice();
        System.out.println("list = " + list);
        Gson gson = new Gson();
        String result = gson.toJson(list);
        System.out.println("result = " + result);
        return result;
    }

    @RequestMapping(value = "/mallProfitFluctuatingView")
    public String mallProfitFluctuatingView() {
        return "mallProfitFluctuatingView";
    }

    @RequestMapping("showAll")
    public String showAll() {
        return "showAll";
    }
}
