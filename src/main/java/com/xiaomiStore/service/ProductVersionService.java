package com.xiaomiStore.service;

import com.xiaomiStore.pojo.ProductVersion;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductVersionService {

    int insert(@Param("record") ProductVersion record);

    int delete(String versionId);

    int update(@Param("record") ProductVersion record);

    ProductVersion select(String versionId);

    List<ProductVersion> selectAll();
}
