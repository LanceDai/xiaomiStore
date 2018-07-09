package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.UserDao;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int insert(User record) {
        return userDao.insert(record);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public User selectByPrimaryKey(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public User selectByUserName(String userName) {
        return userDao.selectByUserName(userName);
    }

    @Override
    public int update(User record) {
        return userDao.update(record);
    }

    @Override
    public int delete(String userId) {
        return userDao.delete(userId);
    }

    @Override
    public List<Map<String, String>> selectUserStatus() {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Timestamp> timestampList = userDao.selectTime();
        for (Timestamp time : timestampList) {
            String date = time.getMonth() + 1 + "月" + time.getDate() + "日";
            map.put(date, map.containsKey(date) ? map.get(date) + 1 : 1);
        }
        List<Map<String, String>> maps = new ArrayList<>();
        for (String str : map.keySet()) {
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("createTime", str);
            stringStringMap.put("num", String.valueOf(map.get(str)));
            maps.add(stringStringMap);
        }
        return maps;
    }
}
