package com.expt.Expt_SoftwareEngineer.controller;

import com.expt.Expt_SoftwareEngineer.pojo.Result;
import com.expt.Expt_SoftwareEngineer.pojo.User;
import com.expt.Expt_SoftwareEngineer.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public Result signup(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){
        // 查询用户名是否被占用
        User user = userService.findByUserName(username);
        if (user == null){
            // 未被占用，注册用户
            userService.register(username,password);
            return Result.success();
        }else {
            // 被占用，返回错误
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        if (loginUser == null){
            return Result.error("用户名错误");
        }
        if (password.equals(loginUser.getPassword())) {
            // todo JWT
            return Result.success("JWT令牌");
        }
        return Result.error("密码错误");
    }
}
