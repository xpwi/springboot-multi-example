package com.xiaopengwei.sprngboot.shiro.sevice;

import com.xiaopengwei.sprngboot.shiro.entity.UserInfo;

/**
 * <p>
 *   业务逻辑接口
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-21
 */
public interface UserInfoService {

    /**
     * 通过username查找用户信息
     *
     * @param username
     * @return com.xiaopengwei.sprngboot.shiro.entity.UserInfo
     * @author XiaoPengwei.com
     */
     UserInfo findByUsername(String username);

}