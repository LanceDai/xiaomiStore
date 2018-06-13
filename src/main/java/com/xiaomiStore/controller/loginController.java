package com.xiaomiStore.controller;

import com.xiaomiStore.utils.IndexView;
import com.xiaomiStore.pojo.OriginType;
import com.xiaomiStore.pojo.Type;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class loginController {

    private final TypeService typeService;
    private final ProductService productService;

    @Autowired
    public loginController(TypeService typeService, ProductService productService) {
        this.typeService = typeService;
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        IndexView indexView = new IndexView();
        List<Type> typeList = typeService.selectByParentId(String.valueOf(0));
        for (Type t : typeList) {
            OriginType originType = new OriginType();
            originType.setType(t);
            originType.setTypeList(typeService.selectByParentId(t.getTypeId()));
            originType.setProductList(productService.selectByTypeId(t.getTypeId()));
            indexView.getOriginTypeList().add(originType);
        }
        System.out.println(indexView);
        model.addAttribute("typeList", indexView);
        return "index";
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
