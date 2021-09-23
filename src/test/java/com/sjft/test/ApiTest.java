package com.sjft.test;

import com.sjft.beans.PropertyValue;
import com.sjft.beans.PropertyValues;
import com.sjft.beans.UserDao;
import com.sjft.beans.UserService;
import com.sjft.beans.factory.config.BeanDefinition;
import com.sjft.beans.factory.config.BeanReference;
import com.sjft.beans.factory.support.DefaultListableBeanFactory;
import com.sjft.beans.factory.xml.XmlBeanDefinitionReader;
import com.sjft.common.MyBeanFactoryPostProcessor;
import com.sjft.common.MyBeanPostProcessor;
import com.sjft.context.ClassPathXmlApplicationContext;
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

    @Test
    void test_xml() {
        /*DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 读取配置文件注册 bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("result: " + userService.queryUserInfo());
    }

    @Test
    void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册 bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println(result);

    }

}
