package com.xiaopengwei.springboot.atomikos.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *   索引控制器
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-13
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public String home() {
        return "Hello World!";
    }

}
