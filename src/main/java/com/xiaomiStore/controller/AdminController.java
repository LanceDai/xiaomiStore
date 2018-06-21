package com.xiaomiStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class AdminController {
    @RequestMapping("")
    public String adminHome() {
        return "home";
    }

}
