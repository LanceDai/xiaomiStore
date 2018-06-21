package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Specification;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SpecificationDao {
    @Insert("INSERT INTO xiaomi_specification (colorId, productId, versionId, stock, price) " +
            "VALUES (#{record.colorId},#{record.productId},#{record.versionId},#{record.stock},#{record.price}")
    int insert(@Param("record") Specification record);

    @Delete("DELETE FROM xiaomi_specification WHERE colorId = #{colorId} AND productId = #{productId} AND versionId = #{versionId}")
    int delete(@Param("colorId") String colorId, @Param("productId") String productId, @Param("versionId") String versionId);

    @Update("update xiaomi_specification set " +
            "colorId = #{record.colorId}, " +
            "productId = #{record.productId}, " +
            "versionId = #{record.versionId}, " +
            "stock = #{record.stock}, " +
            "price = #{record.price}, " +
            "specificationId = #{record.specificationId} ")
    int update(@Param("record") Specification record);

    @Select("SELECT * FROM xiaomi_specification WHERE colorId = #{colorId} AND productId = #{productId} AND versionId = #{versionId}")
    Specification select(@Param("colorId") String colorId, @Param("productId") String productId, @Param("versionId") String versionId);

    @Select("SELECT distinct colorId FROM xiaomi_specification WHERE productId = #{productId}")
    List<String> selectAllColorWithProduct(@Param("productId") String productId);

    @Select("SELECT distinct versionId, price FROM xiaomi_specification WHERE productId = #{productId}")
    @MapKey("versionId")
    Map<String, Map<String, String>> selectAllVersionWithProduct(@Param("productId") String productId);

    @Select("SELECT * FROM xiaomi_specification")
    List<Specification> selectAll();

    @Select("SELECT MIN(price) FROM xiaomi_specification WHERE productId = #{productId}")
    String getMinPriceByProductId(String productId);

    @Select("SELECT price FROM xiaomi_specification WHERE specificationId = #{specificationId}")
    double getPriceBySpecificationId(int specificationId);

    @Select("SELECT colorName FROM xiaomi_specification AS s, xiaomi_color AS c " +
            "WHERE s.specificationId = #{specificationId} AND c.colorId = s.colorId")
    String getColorNameBySpecificationId(int specificationId);

    @Select("SELECT detailVersion FROM xiaomi_specification AS s, xiaomi_product_version AS p " +
            "WHERE s.specificationId = #{specificationId} AND p.versionId = s.versionId")
    String getDetailVersionBySpecificationId(int specificationId);

    @Select("SELECT productName FROM xiaomi_specification AS s, xiaomi_product AS p " +
            "WHERE s.specificationId = #{specificationId} AND p.productId = s.productId")
    String getProductNameBySpecificationId(int specificationId);

    @Select("SELECT specificationId " +
            "FROM xiaomi_specification " +
            "WHERE colorId = #{colorId} " +
            "AND productId = #{productId} " +
            "AND versionId = #{versionId}")
    int getSpecificationIdByProductIdAndColorIdAndVersionId(@Param("productId") String productId,
                                                            @Param("versionId") String versionId,
                                                            @Param("colorId") String colorId);
}
