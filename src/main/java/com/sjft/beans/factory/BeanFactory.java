package com.sjft.beans.factory;

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
     */
    Object getBean(String name, Object... args);
}
