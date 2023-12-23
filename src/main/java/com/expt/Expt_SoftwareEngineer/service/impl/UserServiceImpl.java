package com.expt.Expt_SoftwareEngineer.service.impl;

import com.expt.Expt_SoftwareEngineer.mapper.UserMapper;
import com.expt.Expt_SoftwareEngineer.pojo.User;
import com.expt.Expt_SoftwareEngineer.service.UserService;
import com.expt.Expt_SoftwareEngineer.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void signup(String username, String password) {
        userMapper.addUser(username, password);
    }

    @Override
    public void update(User user) {
        // 获取用户ID
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("userId");
        // 设置用户信息
        user.setUserId(id);
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        // 获取用户ID
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("userId");
        // 设置用户头像URL
        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePwd(String newPwd) {
        // 获取用户ID
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("userId");
        // 设置用户密码
        userMapper.updatePwd(newPwd, id);
    }
}
