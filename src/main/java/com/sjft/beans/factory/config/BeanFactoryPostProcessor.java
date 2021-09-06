package com.sjft.beans.factory.config;

import com.sjft.beans.BeansException;
import com.sjft.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author sift
 * @date 2021-08-23 20:43
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后, 实例化 bean 对象之前, 提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
