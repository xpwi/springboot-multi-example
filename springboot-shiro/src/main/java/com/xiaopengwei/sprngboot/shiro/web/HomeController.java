package com.xiaopengwei.sprngboot.shiro.web;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 前置控制器
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-21
 */
@Controller
public class HomeController {

    /**
     * 索引
     *
     * @return java.lang.String
     * @author XiaoPengwei.com
     */
    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    /**
     * 登录
     *
     * @param request
     * @param map
     * @return java.lang.String
     * @author XiaoPengwei.com
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {

        System.out.println("HomeController.login()");

        // 登录失败从 request 中获取 shiro 处理的异常信息.
        // shiroLoginFailure: 就是 shiro 异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";

        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);

        // 此方法不处理登录成功,由 shiro 进行处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }

}