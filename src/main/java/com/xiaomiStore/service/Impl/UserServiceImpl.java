package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.UserDao;
import com.xiaomiStore.pojo.User;
import com.xiaomiStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int update(User record) {
        return userDao.update(record);
    }

    @Override
    public int delete(String userId) {
        return userDao.delete(userId);
    }
}
