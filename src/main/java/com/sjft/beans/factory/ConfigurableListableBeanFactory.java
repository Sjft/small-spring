package com.sjft.beans.factory;

import com.sjft.beans.BeansException;
import com.sjft.beans.factory.config.AutowireCapableBeanFactory;
import com.sjft.beans.factory.config.BeanDefinition;
import com.sjft.beans.factory.config.BeanPostProcessor;
import com.sjft.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author sift
 * @date 2021-08-23 20:47
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void preInstantiateSingletons() throws BeansException;
}
