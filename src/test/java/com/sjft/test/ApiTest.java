package com.sjft.test;

import com.sjft.beans.PropertyValue;
import com.sjft.beans.PropertyValues;
import com.sjft.beans.UserDao;
import com.sjft.beans.UserService;
import com.sjft.beans.factory.config.BeanDefinition;
import com.sjft.beans.factory.config.BeanReference;
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

        // 2. userDao 注册
        BeanDefinition beanDefinition = new BeanDefinition(UserDao.class);
        beanFactory.registerBeanDefinition("userDao", beanDefinition);

        // 3. userService 设置属性[uId, userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", 0));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. userService 注册
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));

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
