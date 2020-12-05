package com.xiaopengwei.springboot.multi.sources.service;

import com.xiaopengwei.springboot.multi.sources.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  数据源 1 业务逻辑层接口
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-12
 */
public interface Test1Service {

    List<UserInfo> selectUserInfo();
    String insertOneInfo(UserInfo userInfo);

}
