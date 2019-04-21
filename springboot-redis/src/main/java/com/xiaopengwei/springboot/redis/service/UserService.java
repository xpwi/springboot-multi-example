package com.xiaopengwei.springboot.redis.service;

import com.xiaopengwei.springboot.redis.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findById(String id);

    void delete(User user);

    List<User> findAll();
}
