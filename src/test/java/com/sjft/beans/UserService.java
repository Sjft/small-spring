package com.sjft.beans;

/**
 * @author Sjft
 * @date 2021/07/28 14:35
 **/
public class UserService {

    private String uId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.getUserName(uId);
    }
}
