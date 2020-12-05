package com.xiaopengwei.springboot.redis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * User
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-02
 */
@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity{
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "age")
    private int age;
}
