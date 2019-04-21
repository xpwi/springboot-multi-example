package com.xiaopengwei.springboot.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *   索引 - 前置控制器
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-21
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "--> https://xiaopengwei.com");
        return "hello";
    }

}