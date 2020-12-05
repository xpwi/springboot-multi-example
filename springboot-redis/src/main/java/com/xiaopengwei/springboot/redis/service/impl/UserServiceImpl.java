package com.xiaopengwei.springboot.redis.service.impl;

import com.xiaopengwei.springboot.redis.dao.UserDao;
import com.xiaopengwei.springboot.redis.entity.User;
import com.xiaopengwei.springboot.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  UserServiceImpl
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-02
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
