package com.sjft.beans.factory.config;

/**
 * @author Sjft
 * @date 2021/7/28
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean
     * @param beanName bean名称
     * @return 单例对象
     */
    Object getSingleton(String beanName);
}
