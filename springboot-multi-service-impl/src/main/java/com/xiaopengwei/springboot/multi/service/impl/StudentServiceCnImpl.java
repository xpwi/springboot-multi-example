package com.xiaopengwei.springboot.multi.service.impl;

import com.xiaopengwei.springboot.multi.constants.ServiceMapConstants;
import com.xiaopengwei.springboot.multi.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 中国站 | 方式一
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
@Service(ServiceMapConstants.StudentServiceConstants.REQUEST_SITE_CN)
public class StudentServiceCnImpl implements StudentService {

    @Override
    public String findStudentName(Integer stuId) {
        return "小明 --from cn";
    }
}
