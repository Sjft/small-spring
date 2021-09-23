package com.sjft.beans.factory;

/**
 * @author sifj
 * @date 2021-09-23 17:26
 */
public interface InitializingBean {

    /**
     * bean 属性后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
