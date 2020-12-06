package com.xiaopengwei.springboot.multi.student.service;

/**
 * <p>
 * Student Service
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
public interface StudentService {

    /**
     * 根据id 查询学生名字
     *
     * @param stuId Integer
     * @return String
     */
    String findStudentName(Integer stuId);

}
