package com.xiaomiStore.controller;

import com.xiaomiStore.pojo.Coupon;
import com.xiaomiStore.pojo.Product;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.CouponService;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class APIController {
    private final UserService userService;
    private final ProductService productService;
    private final CouponService couponService;

    @Autowired
    public APIController(UserService userService, ProductService productService, CouponService couponService) {
        this.userService = userService;
        this.productService = productService;
        this.couponService = couponService;
    }

    //用户列表
    @RequestMapping("/usersView")
    public String getUsers() {
        return "user-manage";
    }

    @RequestMapping(value = "/usersData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUsersData() {
        Map<String, Object> map = new HashMap<>();
        //从数据库得到相应数据
        List<User> list = userService.selectAll();
        //按layui表格所需response参数，构造response
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    @RequestMapping("/usersDelete")
    @ResponseBody
    public Map<String, Object> deleteUsers(@Param("userId") String userId) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(userId);
        userService.delete(userId);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("usersUpdate")
    public String usersUpdate() {
        return "user-update";
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Map<String, Object> update(@Param("userId") String userId, @Param("name") String name, @Param("phone") String phone,
                                      @Param("password") String password, @Param("sign") String sign,
                                      @Param("hobby") String hobby, @Param("address") String address) {
        Map<String, Object> map = new HashMap<>();

        User user = userService.selectByPrimaryKey(userId);
        System.out.println(user);
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
        System.out.println(user);
        Integer i = userService.update(user);
        System.out.println(i);
        map.put("msg", "success");
        return map;
    }


    //产品列表
    @RequestMapping("/productView")
    public String getProduct() {
        return "product-manage";
    }

    @RequestMapping("/productData")
    @ResponseBody
    public Map<String, Object> getProductData() {
        Map<String, Object> map = new HashMap<>();
        List<Product> list = productService.selectAll();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    @RequestMapping("/productDelete")
    @ResponseBody
    public Map<String, Object> deleteproduct(@Param("productId") String productId) {
        Map<String, Object> map = new HashMap<>();
        productService.delete(productId);
        map.put("result", "success");
        return map;
    }
    @RequestMapping("/insertProduct")
    @ResponseBody
    public Map<String, Object> insertProduct(@Param("name") String name, @Param("description") String description,
                                             @Param("typeId") String typeId){
        Map<String, Object> map = new HashMap<>();
        Product product = new Product();
        product.setProductId(UUID.randomUUID().toString());
        product.setProductName(name);
        product.setProductDescription(description);
        product.setTypeId(typeId);
        productService.insert(product);
        map.put("msg", "success");
        return map;
    }
    //轮播列表
    @RequestMapping("/loopDisplay")
    public String loopDisplay() {
        return "loopDisplay";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file, @RequestParam("number") String number) {
        Map<String, Object> map = new HashMap<>();
        if (!file.isEmpty()) {
//            String path = request.getServletContext().getRealPath("WEB-INF/static/image/backgroundImage");
            String path = "D:\\github\\xiaomiStore\\web\\WEB-INF\\static\\image\\backgroundImage";
            System.out.println(path);
            String filename = "bg" + number + ".jpg";
            File filePath = new File(path, filename);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            try {
                System.out.println(path + File.separator + filename);
                file.transferTo(new File(path + File.separator + filename));
                map.put("msg", "上传成功");
            } catch (IOException e) {
                map.put("msg", "上传失败");
                return map;
            }
        }
        return map;
    }

    @RequestMapping("/productUpdate")
    public String productUpdate() {
        return "product-update";
    }

    @RequestMapping("/updateProduct")
    @ResponseBody
    public Map<String, Object> updateProduct(@Param("productId") String productId, @Param("name") String name, @Param("description") String description,
                                             @Param("typeId") String typeId) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(productId);
        System.out.println(typeId);
        Product product = productService.select(productId);
        if (!"".equals(name) && name != null) {
            product.setProductName(name);
        }
        if (!"".equals(description) && description != null) {
            product.setProductDescription(description);
        }
        if (!"".equals(typeId) && typeId != null) {
            product.setTypeId(typeId);
        }
        System.out.println(product);
        productService.update(product);

        map.put("msg", "success");
        return map;
    }

    //优惠券列表
    @RequestMapping("/couponView")
    public String getCoupon() {
        return "coupon-manage";
    }

    @RequestMapping(value = "/couponData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCouponData() {
        Map<String, Object> map = new HashMap<>();
        List<Coupon> list = couponService.selectAll();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    @RequestMapping("/couponDelete")
    @ResponseBody
    public Map<String, Object> deleteCoupon(@Param("couponId") String couponId) {
        Map<String, Object> map = new HashMap<>();
        couponService.delete(couponId);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("couponUpdate")
    public String couponUpdate() {
        return "coupon-update";
    }

    @RequestMapping("/updateCoupon")
    @ResponseBody
    public Map<String, Object> update(@Param("couponId") String couponId, @Param("name") String name, @Param("price") String price,
                                      @Param("description") String description, @Param("status") String status) {
        Map<String, Object> map = new HashMap<>();

        Coupon coupon = couponService.selectById(couponId);
        if (!"".equals(name) && name != null) {
            coupon.setName(name);
        }
        if (!"".equals(price) && price != null) {
            coupon.setPrice(price);
        }
        if (!"".equals(description) && price != null) {
            coupon.setDescription(description);
        }
        if (!"".equals(status) && status != null) {
            coupon.setStatus(status);
        }
        couponService.update(coupon);

        map.put("msg", "success");
        return map;
    }

    @RequestMapping("/insertCoupon")
    @ResponseBody
    public Map<String, Object> insertcoupon(@Param("name") String name, @Param("price") String price,
                                            @Param("description") String description, @Param("status") String status) {
        Map<String, Object> map = new HashMap<>();
        Coupon coupon = new Coupon();
        coupon.setCouponId(UUID.randomUUID().toString());
        coupon.setDescription(description);
        coupon.setName(name);
        coupon.setPrice(price);
        coupon.setStatus(status);
        couponService.insert(coupon);
        map.put("msg", "success");
        return map;
    }
}
