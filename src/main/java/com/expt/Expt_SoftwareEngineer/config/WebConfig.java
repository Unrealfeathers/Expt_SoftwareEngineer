package com.expt.Expt_SoftwareEngineer.config;

import com.expt.Expt_SoftwareEngineer.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录和注册接口放行
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login", "/user/signup");
    }
}
