package com.xiaopengwei.springboot.runner.demo;import org.springframework.boot.CommandLineRunner;import org.springframework.core.annotation.Order;import org.springframework.stereotype.Component;/** * <p> * 优先级为2 * </p> * * @author github.com/xpwi * @since 2019-04-17 */@Component@Order(2)public class OrderRunner2 implements CommandLineRunner {    @Override    public void run(String... args) throws Exception {        System.out.println("The OrderRunner2 start to initialize ...");    }}