package com.xiaopengwei.springboot.thymeleaf.web;

import com.xiaopengwei.springboot.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *   示例 - 前置控制器
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-21
 */
@Controller
public class ExampleController {

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "xiaopengwei");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2019/04/21/");
        map.addAttribute("img", "https://xiaopengwei.com");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "xiaopengwei");
        map.addAttribute("age", 2);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "man");
        return "switch";
    }

    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("高手",12,"123456");
        User user2=new User("菜鸟",6,"123456");
        User user3=new User("肖朋伟",6,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }

}