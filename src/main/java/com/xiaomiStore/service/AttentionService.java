package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Attention;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttentionService {

    int insert(@Param("record") Attention record);

    int delete(String userId, String productId);

    List<Attention> select(String userId);
}
