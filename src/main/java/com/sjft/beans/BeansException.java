package com.sjft.beans;

/**
 * 定义 bean 异常
 * @author Sjft
 * @date 2021/07/28 14:07
 **/
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
