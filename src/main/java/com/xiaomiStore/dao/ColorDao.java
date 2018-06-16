package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Color;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ColorDao {
    @Insert("insert into xiaomi_color (colorId, colorName) " +
            "values (#{record.colorId}, #{record.colorName})")
    int insert(@Param("record") Color record);

    @Delete("delete from xiaomi_color where colorId = #{colorId}")
    int delete(String colorId);

    @Update("update xiaomi_color set " +
            "colorName = #{record.colorName}, " +
            "where colorName = ##{record.colorId}")
    int update(@Param("record") Color record);

    @Select("select * from xiaomi_color")
    List<Color> selectAll();

    @Select("SELECT colorName FROm xiaomi_color WHERE colorId = #{colorId}")
    String getColorNameByColorId(String colorId);

    @Select("SELECT colorId FROm xiaomi_color WHERE colorName = #{colorName}")
    String getColorIdByColorName(String colorName);
}
