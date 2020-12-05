package com.xiaopengwei.springboot.mybatis.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *   本项目为整合项目，如果使用 MyBatis Generator 搞不定，
 *   可以克隆单独地址：https://github.com/xpwi/springboot-mybatis
 *   自动生成代码启动类
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-02
 */
public class MybatisGenerator {

    public static void main(String[] args) throws Exception {
        String today = "2019-04-19";

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date now =sdf.parse(today);
        Date d = new Date();

        if(d.getTime()>now.getTime()+1000*60*60*24){
            System.err.println("================== MyBatis Generator 运行失败！================");
            System.err.println("警告: 本程序具有破坏作用, 应该只运行一次, 如果必须要再运行, 需要修改 today 变量为今天, 如:" + sdf.format(new Date()));
            return;
        }

        List<String> warnings = new ArrayList<String>();

        InputStream is= MybatisGenerator.class.getClassLoader().getResource("config/generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("================== MyBatis Generator 运行成功！================");
        System.out.println("生成代码成功, 只能执行一次, 以后执行会覆盖掉 repository, entity, xml 等文件上做的修改");

    }
}
