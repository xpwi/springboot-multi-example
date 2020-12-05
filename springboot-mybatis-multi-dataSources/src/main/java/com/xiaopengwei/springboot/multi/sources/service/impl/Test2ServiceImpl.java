package com.xiaopengwei.springboot.multi.sources.service.impl;

import com.xiaopengwei.springboot.multi.sources.mapper.UserDetailMapper;
import com.xiaopengwei.springboot.multi.sources.entity.UserDetail;
import com.xiaopengwei.springboot.multi.sources.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  数据源 2 业务逻辑层接口
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-12
 */
@Service
public class Test2ServiceImpl implements Test2Service {

    @Autowired
    private UserDetailMapper userDetailMapper;

    public List<UserDetail> selectUserDetail() {
        return userDetailMapper.selectAll();
    }

    @Override
    public String insertOneDetail(UserDetail userDetail) {
        int insert = userDetailMapper.insert(userDetail);
        if (insert == 1) {
            return "1";
        } else {
            return "0";
        }
    }
}
