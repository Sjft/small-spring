package com.sjft.beans.factory;

import com.sjft.beans.BeansException;

/**
 * @author Sjft
 * @date 2021/07/28 11:01
 **/
public interface BeanFactory {

    /**
     * 根据名称获取 bean
     * @param name
     * @return
     */
    Object getBean(String name);

    /**
     * 含入参信息 args 的 getBean 方法
     * @param name
     * @param args
     * @return
     * @throws
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 根据名称，类型获取 bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
