package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.ProductVersion;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductVersionDao {
    @Insert("insert into xiaomi_product_version (versionId, detailVersion) " +
            "values (#{record.versionId}, #{record.detailVersion})")
    int insert(@Param("record") ProductVersion record);

    @Delete("delete from xiaomi_product_version where versionId = #{versionId}")
    int delete(String versionId);

    @Update("update xiaomi_product_version set " +
            "versionId = #{record.versionId}, " +
            "detailVersion = #{record.detailVersion}, ")
    int update(@Param("record") ProductVersion record);

    @Select("select * from xiaomi_product_version where versionId = #{versionId}")
    ProductVersion select(String versionId);

    @Select("select * from xiaomi_product_version")
    List<ProductVersion> selectAll();
}
