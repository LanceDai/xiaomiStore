package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.ProductDao;
import com.xiaomiStore.pojo.Product;
import com.xiaomiStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public int insert(Product record) {
        return productDao.insert(record);
    }

    @Override
    public int delete(String productId) {
        return productDao.delete(productId);
    }

    @Override
    public int update(Product record) {
        return productDao.update(record);
    }

    @Override
    public Product select(String productId) {
        return productDao.selectById(productId);
    }

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    public List<Product> selectByTypeId(String typeId) {
        return productDao.selectByTypeId(typeId);
    }

    @Override
    public String getProductIdByProductName(String productName) {
        return productDao.getProductIdByProductName(productName);
    }
}
