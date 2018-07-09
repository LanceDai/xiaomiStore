package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.AttentionDao;
import com.xiaomiStore.pojo.Attention;
import com.xiaomiStore.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttentionServiceImpl implements AttentionService {
    private final AttentionDao attentionDao;

    @Autowired
    public AttentionServiceImpl(AttentionDao attentionDao) {
        this.attentionDao = attentionDao;
    }

    @Override
    public int insert(Attention record) {
        return attentionDao.insert(record);
    }

    @Override
    public int delete(String userId, String productId) {
        return attentionDao.delete(userId, productId);
    }

    @Override
    public List<Attention> select(String userId) {
        return attentionDao.select(userId);
    }

    @Override
    public Integer isExistByUserIdAndProductId(String userId, String productId) {
        return attentionDao.isExistByUserIdAndProductId(userId, productId);
    }

    @Override
    public List<Map<String,String>> selectAttentionProductNameAndNumber() {
        Map<String, Map<String,String>> map = attentionDao.selectAttentionProductNameAndNumber();
        List<Map<String, String>> list = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String str : strings) {
            list.add(map.get(str));
        }
        return list;
    }
}
