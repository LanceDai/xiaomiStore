package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    int insert(@Param("record") Comment record);

    int delete(String commentId);

    int update(@Param("record") Comment record);

    List<Comment> selectByUserId(String userId);
}
