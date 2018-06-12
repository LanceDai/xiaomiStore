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
    int delete(int productId);

    @Update("update miaomi_product set " +
            "productId = #{record.productId}, " +
            "productName = #{record.productName}, " +
            "produproductDescriptionctId = #{record.produproductDescriptionctId}, " +
            "typeId = #{record.typeId}")
    int update(@Param("record") Product record);

    @Select("select * from xiaomi_product where productId = #{productId}")
    Product select(int productId);

    @Select("select * from xiaomi_product")
    List<Product> selectAll();

    @Select("select * from xiaomi_product where typeId = #{typeId}")
    List<Product> selectByTypeId(String typeId);
}
