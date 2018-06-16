package com.xiaomiStore.controller;

import com.xiaomiStore.pojo.OriginType;
import com.xiaomiStore.pojo.Type;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.TypeService;
import com.xiaomiStore.utils.IndexView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private final TypeService typeService;
    private final ProductService productService;

    @Autowired
    public HomeController(TypeService typeService, ProductService productService) {
        this.typeService = typeService;
        this.productService = productService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        IndexView indexView = new IndexView();
        List<Type> typeList = typeService.selectByParentId(String.valueOf(0));
        for (Type t : typeList) {
            OriginType originType = new OriginType();
            originType.setType(t);
            originType.setTypeList(typeService.selectByParentId(t.getTypeId()));
            originType.setProductList(productService.selectByTypeId(t.getTypeId()));
            indexView.getOriginTypeList().add(originType);
        }
        model.addAttribute("typeList", indexView);
        return "index";
    }

    @RequestMapping("/check/login")
    @ResponseBody
    public Map<String, Object> checkLogin(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        User user = (User) session.getAttribute("loginUser");
        if (null != user) {
            result.put("code", 1);
        }
        return result;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/liebiao")
    public String liebiao() {
        return "resultSet";
    }
}
