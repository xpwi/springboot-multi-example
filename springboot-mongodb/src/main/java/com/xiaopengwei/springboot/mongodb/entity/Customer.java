package com.xiaopengwei.springboot.mongodb.entity;import org.springframework.data.annotation.Id;/** * <p> * 客户 - 实体类 * </p> * * @author github.com/xpwi * @since 2019-04-20 */public class Customer {    @Id    public String id;    public String firstName;    public String lastName;    public Customer() {}    public Customer(String firstName, String lastName) {        this.firstName = firstName;        this.lastName = lastName;    }    @Override    public String toString() {        return String.format(                "Customer[id=%s, firstName='%s', lastName='%s']",                id, firstName, lastName);    }}