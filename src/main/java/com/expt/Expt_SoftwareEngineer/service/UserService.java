package com.expt.Expt_SoftwareEngineer.service;

import com.expt.Expt_SoftwareEngineer.mapper.UserMapper;
import com.expt.Expt_SoftwareEngineer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserMapper userMapper;

    // 根据用户名查询用户
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user;
    }

    // 注册用户
    public void register(String username, String password) {
        // 密码加密处理
        userMapper.addUser(username,password);
    }
}
