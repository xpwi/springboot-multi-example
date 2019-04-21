package com.xiaopengwei.springboot.redis.controller;

import com.xiaopengwei.springboot.redis.base.controller.BaseController;
import com.xiaopengwei.springboot.redis.base.utils.RedisConstants;
import com.xiaopengwei.springboot.redis.base.utils.SpringBootRedisUtil;
import com.xiaopengwei.springboot.redis.base.utils.StateParameter;
import com.xiaopengwei.springboot.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器 - RedisTestController
 * </p>
 *
 * @author Xiao pengwei
 * @since 2019-04-02
 */
@Controller
@RequestMapping("/redis")
public class RedisTestController extends BaseController{

    @Autowired
    SpringBootRedisUtil redisUtil;

    @RequestMapping(value="/list")
    public String view(HttpServletRequest request, String name){
        logger.info("返回列表页面");
        return "/demoPage/listPage/"+ name;
    }

    /**
     * 测试 Redis 读取 - test
     *
     * @param
     * @return org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public ModelMap test(){
        try {
            redisUtil.set("redisTest","This is the test data.", RedisConstants.datebase2);
            String value = redisUtil.get("redisTest",RedisConstants.datebase2).toString();
            logger.info("redisValue="+value);
            logger.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, value, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

    /**
     * 测试读取示例 - setUser
     *
     * @param
     * @return org.springframework.ui.ModelMap
     */
    @RequestMapping(value="/setUser")
    @ResponseBody
    public ModelMap setUser(){
        try {
            User user = new User();
            user.setName("隔壁老王");
            user.setAge(28);
            user.setId(getUuid());
            redisUtil.set("user",user, RedisConstants.datebase1);
            User res = (User)redisUtil.get("user",RedisConstants.datebase1);
            logger.info("res="+res.toString());
            logger.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

}
