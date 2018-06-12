package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartDao {

    @Insert("INSERT INTO xiaomi_shopping_cart ( cartId, userId, versionId, number) " +
            "VALUES(#{record.cartId}, #{record.userId}, #{record.versionId}, #{record.number})")
    int insert(@Param("record") ShoppingCart record);

    @Select("SELECT * FROM xiaomi_shopping_cart")
    List<ShoppingCart> selectAll();

    @Select("SELECT * FROM xiaomi_shopping_cart WHERE cartId = #{cartId}")
    ShoppingCart selectByPrimaryKey(String cartId);

    @Update("UPDATE xiaomi_shopping_cart " +
            " SET userId = #{record.userId}," +
            " versionId = #{record.versionId}," +
            " number = #{record.number}" +
            " WHERE cartId = #{record.cartId}")
    int update(@Param("record") ShoppingCart record);

    @Delete("DELETE FROM xiaomi_shopping_cart WHERE cartId = #{shoppingCartId}")
    int delete(String shoppingCartId);
}
