package com.xiaopengwei.springboot.multi.project.teacher.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * <p>
 *
 * @author github.com/xpwi
 * @since 2020-12-05
 */
@Component
public class ServiceBeanContext implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getProvider(String providerKey) {
        Assert.notNull(providerKey, "provider key not null");
        return context.getBean(providerKey);
    }
}
