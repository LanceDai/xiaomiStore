package com.xiaomiStore.service;

import com.xiaomiStore.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    int insert(ShoppingCart record);

    List<ShoppingCart> selectAll();

    ShoppingCart selectByPrimaryKey(String cartId);

    int update(ShoppingCart record);

    int delete(String shoppingCartId);
}
