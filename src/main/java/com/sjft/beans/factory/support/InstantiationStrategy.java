package com.sjft.beans.factory.support;

import com.sjft.beans.BeansException;
import com.sjft.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 * @author Sjft
 * @date 2021/07/28 15:43
 **/
public interface InstantiationStrategy {

    /**
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
