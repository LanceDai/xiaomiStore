package com.xiaomiStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class productController {
    @RequestMapping("/detail/{productName}")
    public String showDetail(@PathVariable("productName") String productName, Model model){
        System.out.println("productName = " + productName);
        return "detail";
    }

    @RequestMapping("/search/{TypeName}")
    public String showAllProductsWithType(@PathVariable("TypeName") String typeName, Model model){
        System.out.println("typeName = " + typeName);
        return "resultSet";
    }
}
