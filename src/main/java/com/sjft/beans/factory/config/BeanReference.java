package com.sjft.beans.factory.config;

/**
 * 类引用
 * @author sift
 * @date 2021-07-30 21:16
 */
public class BeanReference {
    /**
     * bean 名称
     */
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
