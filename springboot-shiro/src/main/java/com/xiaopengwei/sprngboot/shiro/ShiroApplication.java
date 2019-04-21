package com.xiaopengwei.sprngboot.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroApplication.class, args);

		System.out.println("\n启动成功 | 测试地址");
		System.out.println("提示：/database 含执行 sql, 使用前请先检查是否配置数据库\n");
		System.out.println("登录地址 | http://127.0.0.1:8080/login");
		System.out.println("查询用户 | http://127.0.0.1:8080/userInfo/userList");
		System.out.println("添加用户 | http://127.0.0.1:8080/userInfo/userAdd");
		System.out.println("删除用户 | http://127.0.0.1:8080/userInfo/userDel");
		System.out.println("我的首页 | https://xiaopengwei.com");
	}
}
