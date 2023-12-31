package com.expt.Expt_SoftwareEngineer.service;

import com.expt.Expt_SoftwareEngineer.pojo.User;

public interface UserService {

    // 根据用户名查询用户
    User findByUserName(String username);

    // 注册用户
    void signup(String username, String password);

    // 更新用户信息
    void update(User user);

    // 更新用户头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd);
}
