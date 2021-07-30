package com.sjft.beans.factory.support;

import com.sjft.beans.factory.config.BeanDefinition;

/**
 * @author Sjft
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
