package com.xiaopengwei.springboot.multi.constants;

/**
 * <p>
 * 服务名称映射管理
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
public class ServiceMapConstants {

    /**
     * 学生服务
     */
    public static final String STUDENT_SERVICE_PREFIX = "studentService";


    public static class StudentServiceConstants {
        /**
         * 学生服务 - 中国站
         */
        public static final String REQUEST_SITE_CN = "studentServiceCN";

        /**
         * 学生服务 - 泰国站
         */
        public static final String REQUEST_SITE_TH = "studentServiceTH";
    }
}
