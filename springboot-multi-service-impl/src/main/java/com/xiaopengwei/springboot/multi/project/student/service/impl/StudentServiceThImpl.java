package com.xiaopengwei.springboot.multi.project.student.service.impl;

import com.xiaopengwei.springboot.multi.project.constants.ServiceMapConstants;
import com.xiaopengwei.springboot.multi.student.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生服务 | 泰国站
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
@Service(ServiceMapConstants.StudentServiceConstants.REQUEST_SITE_TH)
public class StudentServiceThImpl implements StudentService {

    @Override
    public String findStudentName(Integer stuId) {
        return "XiaoMing --from th";
    }
}
