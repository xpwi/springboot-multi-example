package com.xiaopengwei.springboot.multi.sources.config;

import com.xiaopengwei.springboot.multi.sources.service.Test1Service;
import com.xiaopengwei.springboot.multi.sources.service.impl.Test1ServiceImpl;
import com.xiaopengwei.springboot.multi.sources.util.DatabaseContextHolder;
import com.xiaopengwei.springboot.multi.sources.util.DatabaseType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>
 *   根据调用的 Service 或 ServiceImpl 切换数据源
 * </p>
 *
 * @author Xiao pengwei
 * @since 2019-04-13
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.xiaopengwei.springboot.multi.sources.service.*.*(..))")
    public void declareJointPointExpression() {
    }

    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point){

        //根据连接点所属的类实例，动态切换数据源
        if (point.getTarget() instanceof Test1Service
                || point.getTarget() instanceof Test1ServiceImpl) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.test1);
        } else {
            //连接点所属的类实例是（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
            DatabaseContextHolder.setDatabaseType(DatabaseType.test2);
        }

    }
}