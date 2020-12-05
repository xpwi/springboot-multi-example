package com.xiaopengwei.springboot.multi.controller;

import com.xiaopengwei.springboot.multi.constants.ServiceMapConstants;
import com.xiaopengwei.springboot.multi.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 学生服务 Web
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
@RestController("/student")
public class StudentController {

    @Autowired
    private Map<String, StudentService> studentServiceMap;

    @ApiOperation(value = "根据 ID 获取学生名称")
    @GetMapping("/getStudentName")
    public String getStudentById(Integer studentId, String source) {
        String key = ServiceMapConstants.STUDENT_SERVICE_PREFIX + source;
        // 如果没找到默认为中国
        StudentService studentService = Optional.ofNullable(studentServiceMap.get(key))
                .orElse(studentServiceMap.get(ServiceMapConstants.StudentServiceConstants.REQUEST_SITE_CN));
        return studentService.findStudentName(studentId);
    }

}
