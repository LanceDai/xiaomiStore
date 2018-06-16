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
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public String register() {
        return "register";
    }

    @RequestMapping("/create")
    @ResponseBody
    public Map<String, Object> registerCreate(@Param("username") String username, @Param("password") String password,
                                              @Param("checkPassword") String checkPassword,
                                              @Param("telephoneNumber") String telephoneNumber, @Param("code") String code, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        System.out.println("create");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        System.out.println("telephoneNumber = " + telephoneNumber);
        System.out.println("code = " + code);
        if (!session.getAttribute(Constants.KAPTCHA_SESSION_KEY).equals(code)) {
            result.put("msg", "CodeError");
            return result;
        }
        if (!password.equals(checkPassword)) {
            result.put("msg", "PasswordError");
            return result;
        }
        if (userService.selectByUserName(username) != null) {
            result.put("msg", "usernameError");
            return result;
        }
        User user = new User();
        user.setUserId(String.valueOf(UUID.randomUUID()));
        user.setUserName(username);
        user.setTelephoneNumber(telephoneNumber);
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setPassword(password);
        System.out.println(user);
        userService.insert(user);
        session.setAttribute("loginUser", user);
        result.put("msg", "true");
        return result;
    }
}
