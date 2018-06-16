package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Color;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColorService {

    int insert(@Param("record") Color record);

    int delete(String colorId);

    int update(@Param("record") Color record);

    List<Color> selectAll();

    String getColorNameByColorId(String colorId);

    String getColorIdByColorName(String colorName);
}
