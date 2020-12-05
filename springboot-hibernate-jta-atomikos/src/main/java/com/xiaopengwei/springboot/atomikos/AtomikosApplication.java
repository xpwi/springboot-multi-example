package com.xiaopengwei.springboot.atomikos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *   启动类
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-13
 */
@SpringBootApplication
public class AtomikosApplication {

	public static void main(String[] args) {

		SpringApplication.run(AtomikosApplication.class, args);

		System.out.println("\n========启动成功 | 测试地址！=========");
		System.out.println("提示：/database 含执行 sql, 使用前请先检查是否配置数据库\n");

		System.out.println("成功：无错误   | http://127.0.0.1:8080/atomikos/store/test");
		System.out.println("失败：带有空值 | http://127.0.0.1:8080/atomikos/store/testWithNull");
		System.out.println("失败：带有异常 | http://127.0.0.1:8080/atomikos/store/testWithException");
		System.out.println("首页    | https://github.com/xpwi\n");

	}

}
