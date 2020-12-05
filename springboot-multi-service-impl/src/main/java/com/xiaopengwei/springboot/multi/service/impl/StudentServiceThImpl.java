package com.xiaopengwei.springboot.multi.service.impl;

import com.xiaopengwei.springboot.multi.constants.ServiceMapConstants;
import com.xiaopengwei.springboot.multi.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 泰国站 | 方式一
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
