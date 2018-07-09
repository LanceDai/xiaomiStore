package com.xiaomiStore.controller;

import com.xiaomiStore.pojo.Attention;
import com.xiaomiStore.pojo.Coupon;
import com.xiaomiStore.pojo.Product;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.AttentionService;
import com.xiaomiStore.service.CouponService;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/selfInfo")
public class SelfInfoController {
    private final UserService userService;
    private final CouponService couponService;
    private final AttentionService attentionService;
    private final ProductService productService;

    @Autowired
    public SelfInfoController(UserService userService, CouponService couponService, AttentionService attentionService, ProductService productService) {
        this.userService = userService;
        this.couponService = couponService;
        this.attentionService = attentionService;
        this.productService = productService;
    }

    @RequestMapping("/")
    public String selfInfo(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        System.out.println("login_user = " + user);
        model.addAttribute("user", user);
        return "self_info";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> update(@Param("name") String name, @Param("phone") String phone,
                                      @Param("password") String password, @Param("sign") String sign,
                                      @Param("hobby") String hobby, @Param("address") String address, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User user = (User) session.getAttribute("loginUser");
        if (!"".equals(name) && name != null) {
            user.setUserName(name);
        }
        if (!"".equals(phone) && phone != null) {
            user.setTelephoneNumber(phone);
        }
        if (!"".equals(password) && password != null) {
            user.setPassword(password);
        }
        if (!"".equals(sign) && sign != null) {
            user.setSign(sign);
        }
        if (!"".equals(hobby) && hobby != null) {
            user.setHobby(hobby);
        }
        if (!"".equals(address) && address != null) {
            user.setAddress(address);
        }
        userService.update(user);
        map.put("msg", "success");
        return map;
    }

    @RequestMapping("/coupon")
    public String coupon(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        List<Coupon> list = couponService.selectAll();
        model.addAttribute("list", list);
        return "userCoupon";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword() {
        return "resetPassword";
    }

    @RequestMapping("/resetPassword/update")
    @ResponseBody
    public Map<String, Object> reset(@Param("password") String password, @Param("newPassword") String newPassword, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        System.out.println(password);
        System.out.println(newPassword);
        Map<String, Object> map = new HashMap<>();
        if (!user.getPassword().equals(password)) {
            map.put("msg", "error");
            return map;
        }
        user.setPassword(newPassword);
        System.out.println(user);
        userService.update(user);
        System.out.println(user);
        map.put("msg", "success");

        return map;
    }

    @RequestMapping("/attention")
    public String attention(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loginUser");
        List<Attention> list = attentionService.select(user.getUserId());
        System.out.println(list);
        List<Product> resultList = new ArrayList<Product>();
        for (Attention attention : list) {
            resultList.add(productService.select(attention.getProductId()));
        }
        System.out.println(resultList);
        model.addAttribute("resultList", resultList);
        return "attention";
    }
}
