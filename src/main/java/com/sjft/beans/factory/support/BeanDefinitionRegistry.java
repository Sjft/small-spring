package com.sjft.beans.factory.support;

import com.sjft.beans.BeansException;
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

    /**
     * 根据 beanName 查询 BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的 beanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的 bean 名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
