package com.sjft.common;

import com.sjft.beans.BeansException;
import com.sjft.beans.PropertyValue;
import com.sjft.beans.PropertyValues;
import com.sjft.beans.factory.ConfigurableListableBeanFactory;
import com.sjft.beans.factory.config.BeanDefinition;
import com.sjft.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author sifj
 * @date 2021-09-23 15:46
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "变更为字节跳动"));
    }
}
