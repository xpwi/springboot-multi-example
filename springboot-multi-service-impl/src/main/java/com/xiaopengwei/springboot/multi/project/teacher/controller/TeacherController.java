package com.xiaopengwei.springboot.multi.project.teacher.controller;

import com.xiaopengwei.springboot.multi.project.constants.ServiceMapConstants;
import com.xiaopengwei.springboot.multi.project.teacher.context.ServiceBeanContext;
import com.xiaopengwei.springboot.multi.project.teacher.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 教师服务 Web
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
@Slf4j
@RestController("/teacher")
public class TeacherController {

    @ApiOperation(value = "根据 ID 获取教师名称")
    @GetMapping("/getTeacherName")
    public String getStudentById(Integer teacherId, String source) {
        try {
            String key = ServiceMapConstants.TEACHER_SERVICE_PREFIX + source;

            TeacherService teacherService = (TeacherService) ServiceBeanContext.getProvider(key);
            if (teacherService != null) {
                return teacherService.findTeacherName(teacherId);
            }
        } catch (Exception e) {
            log.error("TeacherController.getStudentById 发生异常!", e);
        }
        return "";
    }
}
