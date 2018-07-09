package com.xiaomiStore.controller;

import com.xiaomiStore.pojo.Product;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.SpecificationService;
import com.xiaomiStore.service.TypeService;
import com.xiaomiStore.utils.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private final SpecificationService specificationService;

    private final ProductService productService;

    private final TypeService typeService;

    @Autowired
    public ProductController(SpecificationService specificationService, ProductService productService, TypeService typeService) {
        this.specificationService = specificationService;
        this.productService = productService;
        this.typeService = typeService;
    }

    @RequestMapping("/detail/{productName}")
    public String showDetail(@PathVariable("productName") String productName, Model model) {
        //构造商品详情对象
        ProductDetail productDetail = new ProductDetail();
        //将从URL得到的商品名字赋值给商品详情对象
        productDetail.setProductName(productName);
        //从数据库得到相应信息
        String productId = productService.getProductIdByProductName(productName);
        productDetail.setColorList(specificationService.selectAllColorWithProduct(productId));
        productDetail.setVersionList(specificationService.selectAllVersionWithProduct(productId));
        //将商品详情对象加入model
        model.addAttribute("productDetail", productDetail);
        //跳转到详情页
        return "detail";
    }

    @RequestMapping("/search/{TypeName}")
    public String showAllProductsWithType(@PathVariable("TypeName") String typeName, Model model) {
        System.out.println("typeName = " + typeName);
        //从数据库得到此类下的所有商品
        Map<String, String> productMap = new HashMap<>();
        String typeId = typeService.getTypeIdByTypeName(typeName);
        List<Product> productList = productService.selectByTypeId(typeId);
        for (Product p : productList) {
            productMap.put(p.getProductName(), specificationService.getMinPriceByProductId(p.getProductId()));
        }

        System.out.println("productMap = " + productMap);
        model.addAttribute("productMap", productMap);
        model.addAttribute("typeName", typeName);
        return "resultSet";
    }
}
