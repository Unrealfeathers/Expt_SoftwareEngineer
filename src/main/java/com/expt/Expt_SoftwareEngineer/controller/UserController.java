package com.expt.Expt_SoftwareEngineer.controller;

import com.expt.Expt_SoftwareEngineer.pojo.Result;
import com.expt.Expt_SoftwareEngineer.pojo.User;
import com.expt.Expt_SoftwareEngineer.service.UserService;
import com.expt.Expt_SoftwareEngineer.utils.JwtUtil;
import com.expt.Expt_SoftwareEngineer.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public Result<String> signup(@Pattern(regexp = "^\\S{2,16}$") String username, @Pattern(regexp = "^\\S{6,32}$") String password) {
        // 查询用户名是否被占用
        User user = userService.findByUserName(username);
        if (user == null) {
            // 未被占用，注册用户
            userService.signup(username, password);
            return Result.success();
        } else {
            // 被占用，返回错误
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{2,16}$") String username, @Pattern(regexp = "^\\S{6,32}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        if (password.equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", loginUser.getUserId());
            claims.put("userName", loginUser.getUserName());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    @GetMapping("/info")
    public Result<User> info() {
        // 从 ThreadLocal 中获取用户数据
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        // 查询用户
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody User user) {
        // 查询用户名是否被占用
        if (userService.findByUserName(user.getUserName()) == null) {
            // 未被占用，用户登录
            userService.update(user);
            return Result.success();
        } else {
            // 被占用，返回错误
            return Result.error("用户名已被占用");
        }
    }

    @PatchMapping("/updateAvatar")
    public Result<String> updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result<String> updatePwd(@RequestBody Map<String, String> params) {
        // 校验参数
        String oldPwd = params.get("oldPwd");
        String newPwd = params.get("newPwd");
        String rePwd = params.get("rePwd");
        if (oldPwd.isEmpty() || newPwd.isEmpty() || rePwd.isEmpty()) {
            return Result.error("缺少参数");
        }
        // 校验旧密码
        Map<String, Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        User loginUser = userService.findByUserName(userName);
        String password = loginUser.getPassword();

        if (!password.equals(oldPwd)) {
            return Result.error("旧密码错误");
        }
        // 校验重复新密码
        if (!rePwd.equals(newPwd)) {
            return Result.error("新密码重复错误");
        }

        userService.updatePwd(newPwd);
        return Result.success();
    }
}
