package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {
    @Insert("INSERT INTO xiaomi_comment ( commentId, userId, productId, createTime, comment) " +
            "VALUES(#{record.commentId}, #{record.userId}, #{record.productId}, " +
            "#{record.createTime}, #{record.comment})")
    int insert(@Param("record") Comment record);

    @Delete("delete from xiaomi_comment where commentId = #{commentId}")
    int delete(String commentId);

    @Update("UPDATE xiaomi_comment " +
            " SET userId = #{record.userId}," +
            " productId = #{record.productId}," +
            " createTime = #{record.createTime}," +
            " comment = #{record.comment}," +
            " WHERE commentId = #{record.commentId}")
    int update(@Param("record") Comment record);

    @Select("select * from xiaomi_comment where userId = #{userId}")
    List<Comment> selectByUserId(String userId);
}
