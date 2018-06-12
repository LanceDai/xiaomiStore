package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.ProductVersion;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductVersionDao {
    @Insert("insert into xiaomi_product_version (versionId, productId, detailVersion, img, number, price) " +
            "values (#{record.versionId}, #{record.productId}, #{record.detailVersion}, #{record.img}), #{record.number}), #{record.price})")
    int insert(@Param("record") ProductVersion record);

    @Delete("delete from xiaomi_product_version where versionId = #{versionId}")
    int delete(int versionId);

    @Update("update xiaomi_product_version set " +
            "versionId = #{record.versionId}, " +
            "productId = #{record.productId}, " +
            "detailVersion = #{record.detailVersion}, " +
            "img = #{record.img}, " +
            "number = #{record.number}, " +
            "price = #{record.typeId}")
    int update(@Param("record") ProductVersion record);

    @Select("select * from xiaomi_product_version where productId = #{productId}")
    ProductVersion select(int versionId);

    @Select("select * from xiaomi_product_version")
    List<ProductVersion> selectAll();
}
