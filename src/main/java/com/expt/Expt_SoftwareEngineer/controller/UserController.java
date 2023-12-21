package com.expt.Expt_SoftwareEngineer.controller;

import com.expt.Expt_SoftwareEngineer.pojo.Result;
import com.expt.Expt_SoftwareEngineer.pojo.User;
import com.expt.Expt_SoftwareEngineer.service.UserService;
import com.expt.Expt_SoftwareEngineer.utils.JwtUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Result signup(@Pattern(regexp = "^\\S{2,16}$") String username, @Pattern(regexp = "^\\S{2,16}$") String password) {
        // 查询用户名是否被占用
        User user = userService.findByUserName(username);
        if (user == null) {
            // 未被占用，注册用户
            userService.register(username, password);
            return Result.success();
        } else {
            // 被占用，返回错误
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{2,16}$") String username, @Pattern(regexp = "^\\S{2,16}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        if (password.equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("user_id", loginUser.getUserID());
            claims.put("user_name", loginUser.getUserName());
            System.out.println(claims);
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    @GetMapping("/info")
    public Result<User> info(@RequestHeader(name = "Authorization") String token) {
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("user_name");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
}
