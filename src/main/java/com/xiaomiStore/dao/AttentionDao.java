package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Attention;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttentionDao {
    @Insert("insert into xiaomi_attention (userId, productId) " +
            "values (#{record.userID}, #{record.productId})")
    int insert(@Param("record") Attention record);

    @Delete("delete from xiaomi_attention where userId = #{userId} AND productID = #{productId}")
    int delete(String userId, String productId);

    @Select("select * from xiaomi_attention where userId = #{userId}")
    List<Attention> select(String userId);
}
