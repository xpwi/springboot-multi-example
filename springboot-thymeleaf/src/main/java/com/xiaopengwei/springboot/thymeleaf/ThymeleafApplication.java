package com.xiaopengwei.springboot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {

		SpringApplication.run(ThymeleafApplication.class, args);

		System.out.println("\n启动成功 | 测试地址");
		System.out.println("首页 | http://127.0.0.1:8080");
		System.out.println("测试 | http://127.0.0.1:8080/string");
		System.out.println("测试 | http://127.0.0.1:8080/if");
		System.out.println("测试 | http://127.0.0.1:8080/list");
		System.out.println("测试 | http://127.0.0.1:8080/url");
		System.out.println("测试 | http://127.0.0.1:8080/eq");
		System.out.println("测试 | http://127.0.0.1:8080/switch");
		System.out.println("我的首页 | https://github.com/xpwi");
	}

}
