package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeDao {
    @Insert("INSERT INTO xiaomi_user ( typeId, name, parentId) " +
            "VALUES(#{record.typeId}, #{record.name}, #{record.parentId})")
    int insert(@Param("record") Type record);

    @Select("SELECT * FROM xiaomi_type")
    List<Type> selectAll();

    @Select("SELECT * FROM xiaomi_type WHERE typeId = #{typeId}")
    Type selectByPrimaryKey(String typeId);

    @Select("SELECT * FROM xiaomi_type WHERE name = #{typeName}")
    Type selectByName(String typeName);

    @Select("SELECT * FROM xiaomi_type WHERE parentId = #{parentId} AND typeId != 0")
    List<Type> selectByParentId(String parentId);

    @Update("UPDATE xiaomi_type " +
            " SET name = #{record.name}," +
            " parentId = #{record.parentId}" +
            " WHERE typeId = #{record.typeId}")
    int update(@Param("record") Type record);

    @Delete("DELETE FROM xiaomi_type WHERE typeId = #{typeId}")
    int delete(String typeId);
}
