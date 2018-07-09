package com.xiaomiStore.controller;

import com.xiaomiStore.pojo.Order;
import com.xiaomiStore.pojo.ShoppingCart;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.*;
import com.xiaomiStore.utils.ShoppingCartList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private final SpecificationService specificationService;
    private final ProductService productService;
    private final ProductVersionService productVersionService;
    private final ColorService colorService;
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;

    @Autowired
    public ShoppingCartController(SpecificationService specificationService, ColorService colorService, ProductService productService, ProductVersionService productVersionService, ShoppingCartService shoppingCartService, OrderService orderService) {
        this.specificationService = specificationService;
        this.colorService = colorService;
        this.productService = productService;
        this.productVersionService = productVersionService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }

    @RequestMapping("")
    public String shoppingCart(Model model, HttpSession session) {
        //得到session域中已登录的用户信息
        User loginUser = (User) session.getAttribute("loginUser");
        //构造购物车记录列表
        List<ShoppingCartList> shoppingCartLists = new ArrayList<>();
        //从数据库中读取当前用户的购物车记录
        List<ShoppingCart> shoppingCarts = shoppingCartService.selectByUserId(loginUser.getUserId());
        //对shoppingCartLists进行遍历得到商品的具体信息
        for (ShoppingCart s : shoppingCarts) {
            //构造购物车记录对象
            ShoppingCartList shoppingCartList = new ShoppingCartList();
            //从数据库得到商品名
            shoppingCartList.setProductName(
                    specificationService.getProductNameBySpecificationId(s.getSpecificationId()));
            //从数据库得到商品具体版本
            shoppingCartList.setDetailVersion(
                    specificationService.getDetailVersionBySpecificationId(s.getSpecificationId()));
            //从数据库得到商品颜色
            shoppingCartList.setColorName(
                    specificationService.getColorNameBySpecificationId(s.getSpecificationId()));
            //从数据库得到商品数目
            shoppingCartList.setNumber(s.getNumber());
            //从数据库得到商品价格
            shoppingCartList.setPrice(specificationService.
                    getPriceBySpecificationId(s.getSpecificationId()));
            //将购物车记录加入至shoppingCartLists
            shoppingCartLists.add(shoppingCartList);
        }
        //将shoppingCartLists加入至model
        model.addAttribute("shoppingCartList", shoppingCartLists);
        return "shoppingCart";
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ResponseBody
    public void buy(@RequestParam("productName") String productName,
                    @RequestParam("version") String version,
                    @RequestParam("color") String color,
                    @RequestParam(value = "number", required = false) Integer num,
                    HttpSession httpSession) {
        //格式化
        color = color.trim();
        productName = productName.trim();
        version = version.trim();
        //得到session域中已登录的用户信息
        User loginUser = (User) httpSession.getAttribute("loginUser");
        System.out.println("productId = " + productService.getProductIdByProductName(productName));
        System.out.println("versionId = " + productVersionService.getVersionIdByDetailVersion(version));
        System.out.println("colorId = " + colorService.getColorIdByColorName(color));
        //得到具体商品ID
        int specificationId =
                specificationService.getSpecificationIdByProductIdAndColorIdAndVersionId(
                        productService.getProductIdByProductName(productName),
                        colorService.getColorIdByColorName(color),
                        productVersionService.getVersionIdByDetailVersion(version)
                );
        //如果没有得到请求中不存在num的值, 证明这次请求来自详情界面
        if (num == null) {
            //从数据库中读取订单信息
            num = shoppingCartService.
                    getNumberByUserIdAndSpecificationId(loginUser.getUserId(), specificationId);
            //如果num为null,证明是商品是第一次加入购物车
            if (num == null) {
                ShoppingCart shoppingCart =
                        new ShoppingCart(UUID.randomUUID().toString(),
                                loginUser.getUserId(),
                                1, specificationId);
                shoppingCartService.insert(shoppingCart);
            } else {
                //不然将所得到的num加1,存入数据库
                ShoppingCart shoppingCart =
                        shoppingCartService.selectByUserIdAndSpecificationId(loginUser.getUserId(), specificationId);
                shoppingCart.setNumber(shoppingCart.getNumber() + 1);
                shoppingCartService.update(shoppingCart);
            }
        } else {
            //得到num,则更新记录
            ShoppingCart shoppingCart =
                    shoppingCartService.selectByUserIdAndSpecificationId(loginUser.getUserId(), specificationId);
            shoppingCart.setNumber(num);
            shoppingCartService.update(shoppingCart);
        }
    }

    //删除商品
    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(@RequestParam("productName") String productName,
                       @RequestParam("version") String version,
                       @RequestParam("color") String color,
                       HttpSession httpSession) {
        //格式化
        color = color.trim();
        productName = productName.trim();
        version = version.trim();
        //得到session域中已登录的用户信息
        User loginUser = (User) httpSession.getAttribute("loginUser");
        //得到具体商品ID
        int specificationId =
                specificationService.getSpecificationIdByProductIdAndColorIdAndVersionId(
                        productService.getProductIdByProductName(productName),
                        colorService.getColorIdByColorName(color),
                        productVersionService.getVersionIdByDetailVersion(version)
                );
        //根据用户ID和具体商品ID删除购物车中的记录
        shoppingCartService.deleteByUserIdAndSpecificationId(loginUser.getUserId(), specificationId);
    }

    //生成订单
    @RequestMapping(value = "/settlement/{sum}", method = RequestMethod.GET)
    @ResponseBody
    public void settlement(@PathVariable("sum") int sum, HttpSession httpSession) {
        //得到session域中已登录的用户信息
        User loginUser = (User) httpSession.getAttribute("loginUser");
        System.out.println("sum = " + sum);
        //生成订单
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setSum(sum);
        order.setUserId(loginUser.getUserId());
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        order.setStatus(String.valueOf(0));
        orderService.insert(order);
    }
}
