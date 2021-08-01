package com.sjft.core.io;

public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源接口
     * @param location
     * @return
     */
    Resource getResource(String location);
}
