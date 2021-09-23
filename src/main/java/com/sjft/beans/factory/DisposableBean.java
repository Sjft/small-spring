package com.sjft.beans.factory;

/**
 * @author sifj
 * @date 2021-09-23 17:28
 */
public interface DisposableBean {

    /**
     * 销毁 bean 时调用
     * @throws Exception
     */
    void destroy() throws Exception;
}
