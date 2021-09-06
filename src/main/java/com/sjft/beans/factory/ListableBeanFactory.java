package com.sjft.beans.factory;

import com.sjft.beans.BeansException;

import java.util.Map;

/**
 * @author sift
 * @date 2021-08-23 20:52
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的 bean 名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
