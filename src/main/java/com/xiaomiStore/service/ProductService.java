package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductService {
    int insert( Product record);

    int delete(int productId);

    int update( Product record);

    Product select(int productId);

    List<Product> selectAll();

    List<Product> selectByTypeId(String typeId);

    String getProductIdByProductName( String productName);

}


