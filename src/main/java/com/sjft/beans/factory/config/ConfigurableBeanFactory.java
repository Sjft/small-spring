package com.sjft.beans.factory.config;

import com.sjft.beans.factory.HierarchicalBeanFactory;

/**
 * @author sift
 * @date 2021-08-23 20:57
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
