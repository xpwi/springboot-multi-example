package com.xiaopengwei.springboot.atomikos.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 顾客实体类
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-09
 */

@Entity
@Table(name = "customer")
public class Customer {

    /**
     * 编号自动生成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 顾客姓名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 顾客年龄
     */
    @Column(name = "age", nullable = false)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
