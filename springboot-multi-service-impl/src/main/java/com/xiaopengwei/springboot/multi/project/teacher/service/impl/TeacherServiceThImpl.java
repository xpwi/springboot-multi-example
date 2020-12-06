package com.xiaopengwei.springboot.multi.project.teacher.service.impl;

import com.xiaopengwei.springboot.multi.project.constants.ServiceMapConstants;
import com.xiaopengwei.springboot.multi.project.teacher.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教师服务 | 泰国站
 *
 * @author github.com/xpwi
 * @since 2020-12-06
 */
@Service(ServiceMapConstants.TeacherServiceConstants.REQUEST_SITE_TH)
public class TeacherServiceThImpl implements TeacherService {

    @Override
    public String findTeacherName(Integer teacherId) {
        return "Teacher Zhang. --from th";
    }
}
