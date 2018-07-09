package com.xiaomiStore.service;

import com.xiaomiStore.pojo.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
    int insert(User record);

    List<User> selectAll();

    User selectByPrimaryKey(String userId);

    User selectByUserName(String userName);

    int update(User record);

    int delete(String userId);

    List<Map<String, String>> selectUserStatus();
}
