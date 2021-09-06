package com.sjft.context;

import com.sjft.beans.BeansException;

/**
 * @author sift
 * @date 2021-08-23 21:37
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
