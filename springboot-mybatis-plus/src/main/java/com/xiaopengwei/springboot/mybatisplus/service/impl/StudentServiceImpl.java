package com.xiaopengwei.springboot.mybatisplus.service.impl;

import com.xiaopengwei.springboot.mybatisplus.entity.Student;
import com.xiaopengwei.springboot.mybatisplus.mapper.StudentMapper;
import com.xiaopengwei.springboot.mybatisplus.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
