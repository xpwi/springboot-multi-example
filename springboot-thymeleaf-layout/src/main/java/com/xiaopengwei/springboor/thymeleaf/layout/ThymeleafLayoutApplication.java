package com.xiaopengwei.springboor.thymeleaf.layout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafLayoutApplication {

	public static void main(String[] args) {

		SpringApplication.run(ThymeleafLayoutApplication.class, args);

		System.out.println("\n启动成功 | 测试地址");
		System.out.println("首页 | http://127.0.0.1:8080/index");
		System.out.println("测试 | http://127.0.0.1:8080/fragment");
		System.out.println("测试 | http://127.0.0.1:8080/layout");
		System.out.println("测试 | http://127.0.0.1:8080/home");
		System.out.println("我的首页 | https://github.com/xpwi");
	}

}
