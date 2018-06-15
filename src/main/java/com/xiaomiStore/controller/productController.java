package com.xiaomiStore.controller;

import com.xiaomiStore.dao.ProductDao;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.SpecificationService;
import com.xiaomiStore.utils.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class productController {

    private final SpecificationService specificationService;

    private final ProductService productService;

    @Autowired
    public productController(SpecificationService specificationService, ProductService productService) {
        this.specificationService = specificationService;
        this.productService = productService;
    }

    @RequestMapping("/detail/{productName}")
    public String showDetail(@PathVariable("productName") String productName, Model model) {
        System.out.println("productName = " + productName);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductName(productName);
        String productId = productService.getProductIdByProductName(productName);
        productDetail.setColorList(specificationService.selectAllColorWithProduct(productId));
        productDetail.setVersionList(specificationService.selectAllVersionWithProduct(productId));
        model.addAttribute("productDetail", productDetail);
        return "detail";
    }

    @RequestMapping("/search/{TypeName}")
    public String showAllProductsWithType(@PathVariable("TypeName") String typeName, Model model) {
        System.out.println("typeName = " + typeName);
        return "resultSet";
    }
}
