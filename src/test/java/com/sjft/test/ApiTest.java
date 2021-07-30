package com.sjft.test;

import com.sjft.beans.UserService;
import com.sjft.beans.factory.config.BeanDefinition;
import com.sjft.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author Sjft
 * @date 2021/07/28 14:40
 **/
public class ApiTest {

    @Test
    public void beanFactoryTest() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService singleton_uerService = (UserService) beanFactory.getBean("userService");
        singleton_uerService.queryUserInfo();
    }

    @Test
    void test() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "sjft");
        userService.queryUserInfo();
    }
}
