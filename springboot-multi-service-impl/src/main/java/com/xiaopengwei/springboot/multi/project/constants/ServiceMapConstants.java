package com.xiaopengwei.springboot.multi.project.constants;

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

    /**
     * 教师服务
     */
    public static final String TEACHER_SERVICE_PREFIX = "teacherService";


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

    public static class TeacherServiceConstants {
        /**
         * 教师服务 - 中国站
         */
        public static final String REQUEST_SITE_CN = "teacherServiceCN";

        /**
         * 教师服务 - 泰国站
         */
        public static final String REQUEST_SITE_TH = "teacherServiceTH";
    }
}
