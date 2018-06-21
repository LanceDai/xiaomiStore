package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Attention;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttentionDao {
    @Insert("insert into xiaomi_attention (userId, productId) " +
            "values (#{record.userId}, #{record.productId})")
    int insert(@Param("record") Attention record);

    @Delete("delete from xiaomi_attention where userId = #{userId} AND productID = #{productId}")
    int delete(@Param("userId") String userId,
               @Param("productId") String productId);

    @Select("select * from xiaomi_attention where userId = #{userId}")
    List<Attention> select(String userId);

    @Select("SELECT count(*) FROM xiaomi_attention " +
            "WHERE userId = #{userId} AND productId = #{productId}")
    int isExistByUserIdAndProductId(@Param("userId") String userId,
                                    @Param("productId") String productId);
}
