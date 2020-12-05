package com.xiaopengwei.springboot.multi.sources.service;

import com.xiaopengwei.springboot.multi.sources.entity.UserDetail;

import java.util.List;

/**
 * <p>
 *  数据源 2 业务逻辑层接口
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-12
 */
public interface Test2Service {

    List<UserDetail> selectUserDetail();
    String insertOneDetail(UserDetail userDetail);

}
