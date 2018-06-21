package com.xiaomiStore.controller;


import com.google.code.kaptcha.Constants;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/check")
    @ResponseBody
    public Map<String, String> loginCheck(@Param("username") String username, @Param("password") String password, @Param("code") String code, HttpSession session) {
        Map<String, String> msg = new HashMap<>();
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("code = " + code);
        System.out.println(session.getAttribute(Constants.KAPTCHA_SESSION_KEY));
        User user = userService.selectByUserName(username);
        System.out.println(user.toString());
        if (!code.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
            msg.put("msg", "CodeError");
            return msg;
        }
        if (password.equals(user.getPassword())) {
            System.out.println("true");
            msg.put("msg", "true");
            session.setAttribute("loginUser", user);
        } else {
            System.out.println("false");
            msg.put("msg", "false");
        }
        return msg;
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
//        session.invalidate();
        session.removeAttribute("loginUser");
        return "redirect:/";
    }

}
