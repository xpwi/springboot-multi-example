package com.xiaopengwei.springboot.multi.sources.controller;

import com.xiaopengwei.springboot.multi.sources.entity.UserDetail;
import com.xiaopengwei.springboot.multi.sources.entity.UserInfo;
import com.xiaopengwei.springboot.multi.sources.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *   测试数据源 前置控制器
 * </p>
 *
 * @author Xiao pengwei
 * @since 2019-04-12
 */
@RestController
@RequestMapping("/dataSource")
public class TestDataSourceController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public List<UserInfo> selectUser() {
        System.out.println("查询第一个数据源");
        return commonService.selectUserInfo();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public List<UserDetail> userDetail() {
        System.out.println("查询第二个数据源");
        return commonService.selectUserDetail();
    }

}