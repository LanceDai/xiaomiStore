package com.xiaomiStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("")
    public String adminHome() {
        return "home";
    }

    @RequestMapping("login")
    public String adminLogin() {
        return "admin_login";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> loginCheck(@RequestParam("username") String username,
                                          @RequestParam("password") String password,
                                          HttpSession session) {
        Map<String, String> msg = new HashMap<>();
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        if ("root".equals(username) && "root".equals(password)) {
            session.setAttribute("adminStatus", "true");
            msg.put("msg", "true");
        } else {
            msg.put("msg", "false");
        }
        return msg;
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("adminStatus");
        return "redirect:/home/login";
    }
}
