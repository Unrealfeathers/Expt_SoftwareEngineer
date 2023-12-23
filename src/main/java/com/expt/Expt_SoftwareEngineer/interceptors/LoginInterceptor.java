package com.expt.Expt_SoftwareEngineer.interceptors;

import com.expt.Expt_SoftwareEngineer.utils.JwtUtil;
import com.expt.Expt_SoftwareEngineer.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 令牌验证
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);

            // 存储业务数据
            ThreadLocalUtil.set(claims);

            return true;
        } catch (Exception exception) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清楚 ThreadLocal 中的业务数据
        ThreadLocalUtil.remove();
    }
}
