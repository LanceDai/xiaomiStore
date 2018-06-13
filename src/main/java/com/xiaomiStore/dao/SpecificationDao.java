package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Specification;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SpecificationDao {
    @Insert("INSERT INTO xiaomi_specification (colorId, productId, versionId, stock, price) " +
            "VALUES (#{record.colorId},#{record.productId},#{record.versionId},#{record.stock},#{record.price}")
    int insert(@Param("record") Specification record);

    @Delete("DELETE FROM xiaomi_specification WHERE colorId = #{colorId} AND productId = #{productId} AND versionId = #{versionId}")
    int delete(@Param("colorId") String colorId, @Param("productId") String productId, @Param("versionId") String versionId);

    @Update("update xiaomi_specification set " +
            "versionId = #{record.versionId}, " +
            "detailVersion = #{record.detailVersion}, ")
    int update(@Param("record") Specification record);

    @Select("SELECT * FROM xiaomi_specification WHERE colorId = #{colorId} AND productId = #{productId} AND versionId = #{versionId}")
    Specification select(@Param("colorId") String colorId, @Param("productId") String productId, @Param("versionId") String versionId);

    @Select("SELECT * FROM xiaomi_specification")
    List<Specification> selectAll();
}
