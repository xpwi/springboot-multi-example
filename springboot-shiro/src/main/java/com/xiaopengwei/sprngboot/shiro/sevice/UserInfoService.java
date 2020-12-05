package com.xiaopengwei.sprngboot.shiro.sevice;

import com.xiaopengwei.sprngboot.shiro.entity.UserInfo;

/**
 * <p>
 *   业务逻辑接口
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-21
 */
public interface UserInfoService {

    /**
     * 通过username查找用户信息
     *
     * @param username
     * @return com.xiaopengwei.sprngboot.shiro.entity.UserInfo
     * @author github.com/xpwi
     */
     UserInfo findByUsername(String username);

}
