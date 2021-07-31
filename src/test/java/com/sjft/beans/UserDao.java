package com.sjft.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sift
 * @date 2021-07-31 15:08
 */
public class UserDao {

    private static Map<Integer, String> hashMap = new HashMap<Integer, String>();

    static {
        hashMap.put(0, "王也");
        hashMap.put(1, "张灵玉");
        hashMap.put(2, "诸葛青");
    }

    public String getUserName(Integer id) {
        return hashMap.get(id);
    }
}
