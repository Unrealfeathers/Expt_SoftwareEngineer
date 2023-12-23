package com.expt.Expt_SoftwareEngineer.service.impl;

import com.expt.Expt_SoftwareEngineer.mapper.UserMapper;
import com.expt.Expt_SoftwareEngineer.pojo.User;
import com.expt.Expt_SoftwareEngineer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        userMapper.addUser(username, password);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }
}
