package com.xiaomiStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @RequestMapping("")
    public String shoppingCart() {
        return "shoppingCart";
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public void buy(@RequestParam("productName") String productName,
                    @RequestParam("version") String version,
                    @RequestParam("color") String color) {
    }
}
