package com.cxfd.demo.service.impl;

import com.cxfd.demo.pojo.User;
import com.cxfd.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * UserServiceImpl
 *
 * @author dusk
 * @since 2019/7/31
 */
@Service
@WebService(targetNamespace = "http://service.demo.cxfd.com/", endpointInterface = "com.cxfd.demo.service.UserService")
public class UserServiceImpl implements UserService {
    private Map<String, User> userMap = new HashMap<>();

    public UserServiceImpl() {
        System.out.println("inster实体类数据");
        User user = new User();
        user.setUserId("411001");
        user.setUserName("zhansan");
        user.setAge("20");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411002");
        user.setUserName("lisi");
        user.setAge("30");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411003");
        user.setUserName("wangwu");
        user.setAge("40");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);
    }

    @Override
    public String getName(String userId) {
        System.out.println("in getName fun" + userId);
        return "liyd" + userId;
    }

    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }
}
