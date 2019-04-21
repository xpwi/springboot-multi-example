package com.xiaopengwei.springboot.redis.dao;

import com.xiaopengwei.springboot.redis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * User操作 开启事务 - UserDao
 * </p>
 *
 * @author Xiao pengwei
 * @since 2019-04-02
 */
@Transactional
public interface UserDao extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User>,JpaRepository<User,Long> {
    User findById(String id);
}
