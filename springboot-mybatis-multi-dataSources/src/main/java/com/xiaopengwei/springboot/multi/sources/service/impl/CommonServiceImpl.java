package com.xiaopengwei.springboot.multi.sources.service.impl;

import com.xiaopengwei.springboot.multi.sources.entity.UserDetail;
import com.xiaopengwei.springboot.multi.sources.entity.UserInfo;
import com.xiaopengwei.springboot.multi.sources.service.CommonService;
import com.xiaopengwei.springboot.multi.sources.service.Test1Service;
import com.xiaopengwei.springboot.multi.sources.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  业务逻辑层实现
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-12
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private Test1Service test1Service;

    @Autowired
    private Test2Service test2Service;

    public List<UserInfo> selectUserInfo() {
        return test1Service.selectUserInfo();
    }

    public List<UserDetail> selectUserDetail() {
        return test2Service.selectUserDetail();
    }

    public String insertOneInfo(UserInfo userInfo) {
        return test1Service.insertOneInfo(userInfo);
    }

    @Override
    public String insertOneDetail(UserDetail userDetail) {
        return test2Service.insertOneDetail(userDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertInfoAndDetail(UserInfo userInfo, UserDetail userDetail) {

        String insertOneInfo = test1Service.insertOneInfo(userInfo);
        String insertOneDetail = test2Service.insertOneDetail(userDetail);

        return insertOneInfo+"|"+insertOneDetail;
    }

}
