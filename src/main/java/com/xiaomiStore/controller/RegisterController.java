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
        //判断验证码是否相同
        if (!session.getAttribute(Constants.KAPTCHA_SESSION_KEY).equals(code)) {
            System.out.println("CodeError");
            System.out.println(session.getAttribute(Constants.KAPTCHA_SESSION_KEY) + " " +code);
            result.put("msg", "CodeError");
            return result;
        }
        System.out.println("code ok");
        //判断两次输入密码是否相同
        if (!password.equals(checkPassword)) {
            result.put("msg", "PasswordError");
            return result;
        }
        System.out.println("password ok");
        //判断用户名是否重复
        if (userService.selectByUserName(username) != null) {
            result.put("msg", "usernameError");
            return result;
        }
        //构造user对象，并赋予相应值
        User user = new User();
        user.setUserId(String.valueOf(UUID.randomUUID()));
        user.setUserName(username);
        user.setTelephoneNumber(telephoneNumber);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setPassword(password);
        System.out.println(user);
        userService.insert(user);
        //将此用户存入session域，表示已登陆
        session.setAttribute("loginUser", user);
        result.put("msg", "true");
        return result;
    }
}
