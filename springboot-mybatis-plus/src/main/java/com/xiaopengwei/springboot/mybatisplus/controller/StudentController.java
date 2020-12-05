package com.xiaopengwei.springboot.mybatisplus.controller;


import com.xiaopengwei.springboot.mybatisplus.entity.Student;
import com.xiaopengwei.springboot.mybatisplus.entityvo.ReturnMessage;
import com.xiaopengwei.springboot.mybatisplus.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/create")
    public ReturnMessage create(){

        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setState("0");
        returnMessage.setMessage("创建失败！");

        Student student = new Student();
        student.setId(12);
        student.setName("xiaopengwei");
        student.setStudentId("5466");

        boolean insert = studentServiceImpl.insert(student);
        if (insert){
            returnMessage.setState("1");
            returnMessage.setMessage("创建学生成功！");
        }

        return returnMessage;
    }

}

