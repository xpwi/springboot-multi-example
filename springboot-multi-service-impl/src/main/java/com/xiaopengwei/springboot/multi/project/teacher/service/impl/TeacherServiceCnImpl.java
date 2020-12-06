package com.xiaopengwei.springboot.multi.project.teacher.service.impl;

import com.xiaopengwei.springboot.multi.project.constants.ServiceMapConstants;
import com.xiaopengwei.springboot.multi.project.teacher.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教师服务 | 中国站
 *
 * @author github.com/xpwi
 * @since 2020-12-06
 */
@Service(ServiceMapConstants.TeacherServiceConstants.REQUEST_SITE_CN)
public class TeacherServiceCnImpl implements TeacherService {

    @Override
    public String findTeacherName(Integer teacherId) {
        return "张老师 --from cn";
    }
}
