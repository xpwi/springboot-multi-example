package com.xiaopengwei.springboot.multi.sources.service.impl;

import com.xiaopengwei.springboot.multi.sources.mapper.UserInfoMapper;
import com.xiaopengwei.springboot.multi.sources.entity.UserInfo;
import com.xiaopengwei.springboot.multi.sources.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  数据源 1 业务逻辑层接口
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-12
 */
@Service
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> selectUserInfo() {
        return userInfoMapper.selectAll();
    }

    public String insertOneInfo(UserInfo userInfo) {

        int insert = userInfoMapper.insert(userInfo);

        if (insert == 1) {
            return "1";
        } else {
            return "0";
        }
    }

}
