package com.xiaopengwei.sprngboot.shiro.sevice.impl;

import com.xiaopengwei.sprngboot.shiro.repository.UserInfoRepository;
import com.xiaopengwei.sprngboot.shiro.entity.UserInfo;
import com.xiaopengwei.sprngboot.shiro.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *   业务逻辑处理
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-21
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {

        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }

}
