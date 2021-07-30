package com.sjft.beans;

/**
 * @author Sjft
 * @date 2021/07/28 14:35
 **/
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息:" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(name).toString();
    }
}
