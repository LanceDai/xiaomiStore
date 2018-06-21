package com.xiaomiStore.service;

import com.xiaomiStore.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    int insert(ShoppingCart record);

    List<ShoppingCart> selectAll();

    List<ShoppingCart> selectByUserId(String userId);

    ShoppingCart selectByPrimaryKey(String cartId);

    int update(ShoppingCart record);

    int delete(String shoppingCartId);

    Integer getNumberByUserIdAndSpecificationId(String userId, int specificationId);

    ShoppingCart selectByUserIdAndSpecificationId(String userId, int specificationId);

    int deleteByUserIdAndSpecificationId(String userId, int specificationId);
}
