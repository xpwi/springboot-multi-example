package com.xiaopengwei.springboot.mybatis.controller;import com.xiaopengwei.springboot.multi.sources.config.UserConfig;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;/** * <p> * 自定义配置文件读取测试 * 方式二：通过实例获取 * </p> * * @author github.com/xpwi * @since 2019-04-19 */@RestControllerpublic class UserConfigMethod2Controller {    @Autowired    UserConfig userConfig;    @RequestMapping(value = "/userConfig2")    public String user(){        return "userConfig2: "+"\n"+userConfig.getGreeting()+"\n"+userConfig.getHome();    }}