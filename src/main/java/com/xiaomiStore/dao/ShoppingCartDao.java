package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartDao {

    @Insert("INSERT INTO xiaomi_shopping_cart ( cartId, userId, number, specificationId) " +
            "VALUES(#{record.cartId}, #{record.userId}, #{record.number}, #{record.specificationId})")
    int insert(@Param("record") ShoppingCart record);

    @Select("SELECT * FROM xiaomi_shopping_cart")
    List<ShoppingCart> selectAll();

    @Select("SELECT * FROM xiaomi_shopping_cart WHERE userId = #{userId}")
    List<ShoppingCart> selectByUserId(String userId);

    @Select("SELECT * FROM xiaomi_shopping_cart WHERE cartId = #{cartId}")
    ShoppingCart selectByPrimaryKey(String cartId);

    @Select("SELECT number FROM xiaomi_shopping_cart WHERE userId = #{userId} AND specificationId = #{specificationId}")
    Integer getNumberByUserIdAndSpecificationId(@Param("userId") String userId,
                                                @Param("specificationId") int specificationId);

    @Select("SELECT * FROM xiaomi_shopping_cart WHERE userId = #{userId} AND specificationId = #{specificationId}")
    ShoppingCart selectByUserIdAndSpecificationId(@Param("userId") String userId,
                                                  @Param("specificationId") int specificationId);

    @Update("UPDATE xiaomi_shopping_cart " +
            " SET userId = #{record.userId}," +
            " number = #{record.number}," +
            " specificationId = #{record.specificationId}" +
            " WHERE cartId = #{record.cartId}")
    int update(@Param("record") ShoppingCart record);

    @Delete("DELETE FROM xiaomi_shopping_cart WHERE cartId = #{shoppingCartId}")
    int delete(String shoppingCartId);

    @Delete("DELETE FROM xiaomi_shopping_cart WHERE userId = #{userId} AND specificationId = #{specificationId}")
    int deleteByUserIdAndSpecificationId(@Param("userId") String userId, @Param("specificationId") int specificationId);

}
