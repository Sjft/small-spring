package com.sjft.common;

import com.sjft.beans.BeansException;
import com.sjft.beans.UserService;
import com.sjft.beans.factory.config.BeanPostProcessor;

/**
 * @author sifj
 * @date 2021-09-23 15:48
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("变更为上海");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
