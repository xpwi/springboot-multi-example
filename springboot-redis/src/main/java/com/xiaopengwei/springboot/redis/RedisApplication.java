package com.xiaopengwei.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>
 * Redis  示例启动类
 * </p>
 *
 * @author github.com/xpwi
 * @since  2019-04-02
 */
@SpringBootApplication
public class RedisApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		System.out.println("外部tomcat,chapter启动!");
		return application.sources(RedisApplication.class);
	}

}
