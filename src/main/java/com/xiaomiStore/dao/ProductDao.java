package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductDao {
    @Insert("insert into xiaomi_product (productId, productName, productDescription, typeId) " +
            "values (#{record.productId}, #{record.productName}, #{record.productDescription}, #{record.typeId})")
    int insert(@Param("record") Product record);

    @Delete("delete from xiaomi_product where productId = #{productId}")
    int delete(String productId);

    @Update("update xiaomi_product set " +
            "productName = #{record.productName}, " +
            "productDescription = #{record.productDescription}, " +
            "typeId = #{record.typeId} where productId = #{record.productId}")
    int update(@Param("record") Product record);

    @Select("select * from xiaomi_product where productId = #{productId}")
    Product selectById(String productId);

    @Select("select * from xiaomi_product")
    List<Product> selectAll();

    @Select("SELECT * FROM xiaomi_product WHERE typeId = #{typeId}")
    List<Product> selectByTypeId(String typeId);

    @Select("SELECT productId FROM xiaomi_product WHERE productName = #{productName}")
    String getProductIdByProductName(String productName);
}
