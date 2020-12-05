package com.xiaopengwei.springboot.multi.sources.service;

import com.xiaopengwei.springboot.multi.sources.entity.UserDetail;
import com.xiaopengwei.springboot.multi.sources.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  业务逻辑层接口
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-12
 */
public interface CommonService {
    List<UserInfo> selectUserInfo();

    List<UserDetail> selectUserDetail();

    String insertOneInfo(UserInfo userInfo);

    String insertOneDetail(UserDetail userDetail);

    String insertInfoAndDetail(UserInfo userInfo, UserDetail userDetail);

}
