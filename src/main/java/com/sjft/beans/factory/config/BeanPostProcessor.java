package com.sjft.beans.factory.config;

import com.sjft.beans.BeansException;

/**
 * @author sift
 * @date 2021-08-23 21:06
 */
public interface BeanPostProcessor {

    /**
     * 在 bean 对象执行初始化方法之前, 执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 bean 对象执行初始化方法之后, 执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
