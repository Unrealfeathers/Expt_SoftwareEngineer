package com.expt.Expt_SoftwareEngineer.service.impl;

import com.expt.Expt_SoftwareEngineer.pojo.User;
import com.expt.Expt_SoftwareEngineer.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends UserService {
    @Override
    public User findByUserName(String username) {
        return super.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        super.register(username, password);
    }
}
