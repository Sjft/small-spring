package com.sjft.beans;

/**
 * @author Sjft
 * @date 2021/07/28 14:35
 **/
public class UserService {

    private Integer uId;

    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.getUserName(uId));
    }
}
