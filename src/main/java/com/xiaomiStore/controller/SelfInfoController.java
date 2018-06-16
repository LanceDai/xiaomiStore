package com.xiaomiStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selfInfo")
public class SelfInfoController {
    @RequestMapping("")
    public String selfInfo(){
        return "self_info";
    }
}
