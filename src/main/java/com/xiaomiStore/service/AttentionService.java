package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Attention;

import java.util.List;
import java.util.Map;

public interface AttentionService {

    int insert(Attention record);

    int delete(String userId, String productId);

    List<Attention> select(String userId);

    Integer isExistByUserIdAndProductId(String userId, String productId);

    List<Map<String, String>> selectAttentionProductNameAndNumber();
}
