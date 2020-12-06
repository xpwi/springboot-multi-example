package com.xiaopengwei.springboot.multi.project.teacher.service;

/**
 * <p>
 * Teacher Service
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
public interface TeacherService {

    /**
     * 根据id 查询教师名字
     *
     * @param teacherId Integer
     * @return String
     */
    String findTeacherName(Integer teacherId);
}
