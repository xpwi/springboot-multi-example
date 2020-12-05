package com.xiaopengwei.springboot.multi.sources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-12
 */
@EnableTransactionManagement(order = 2)
@SpringBootApplication(scanBasePackages = "com.xiaopengwei", exclude = {DataSourceAutoConfiguration.class})
public class MultiDataSourcesApplication {

    public static void main(String[] args) {

        SpringApplication.run(MultiDataSourcesApplication.class, args);

        System.out.println("\n========启动成功！=========");
        System.out.println("提示：/database 含执行 sql, 使用前请先检查是否配置数据库\n");

        System.out.println("首页 索引   地址 | http://127.0.0.1:8080/");
        System.out.println("测试数据源1 地址 | http://127.0.0.1:8080/dataSource/test1");
        System.out.println("测试数据源2 地址 | http://127.0.0.1:8080/dataSource/test2");
        System.out.println("首页    | https://github.com/xpwi\n");
    }


}
