package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.ShoppingCartDao;
import com.xiaomiStore.pojo.ShoppingCart;
import com.xiaomiStore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    @Override
    public int insert(ShoppingCart record) {
        return shoppingCartDao.insert(record);
    }

    @Override
    public List<ShoppingCart> selectAll() {
        return shoppingCartDao.selectAll();
    }

    @Override
    public List<ShoppingCart> selectByUserId(String userId) {
        return shoppingCartDao.selectByUserId(userId);
    }

    @Override
    public ShoppingCart selectByPrimaryKey(String cartId) {
        return shoppingCartDao.selectByPrimaryKey(cartId);
    }

    @Override
    public int update(ShoppingCart record) {
        return shoppingCartDao.update(record);
    }

    @Override
    public int delete(String shoppingCartId) {
        return shoppingCartDao.delete(shoppingCartId);
    }

    @Override
    public Integer getNumberByUserIdAndSpecificationId(String userId, int specificationId) {
        return shoppingCartDao.getNumberByUserIdAndSpecificationId(userId, specificationId);
    }

    @Override
    public ShoppingCart selectByUserIdAndSpecificationId(String userId, int specificationId) {
        return shoppingCartDao.selectByUserIdAndSpecificationId(userId, specificationId);
    }

    @Override
    public int deleteByUserIdAndSpecificationId(String userId, int specificationId) {
        return shoppingCartDao.deleteByUserIdAndSpecificationId(userId, specificationId);
    }

}
