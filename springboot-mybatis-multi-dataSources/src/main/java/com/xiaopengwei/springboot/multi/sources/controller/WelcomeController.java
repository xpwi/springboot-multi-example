package com.xiaopengwei.springboot.multi.sources.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *   首页索引
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-12
 */
@RestController
public class WelcomeController {

    @RequestMapping("/")
    public Map welcome() {
        Map<String,Object> model = new HashMap();
        model.put("time", new Date());
        model.put("message", "Hello World");
        return model;
    }

}
