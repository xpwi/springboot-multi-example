package com.xiaopengwei.springboot.mybatisplus.mapper;

import com.xiaopengwei.springboot.mybatisplus.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 学生表 Mapper 接口
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-11
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
