package com.xiaopengwei.springboot.atomikos.repository.customer;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *   数据源连接配置 POJO 类
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-09
 */
@ConfigurationProperties(prefix = "customer.datasource")
public class CustomerDatasourceProperties {

    private String url;

    private String username;

    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
