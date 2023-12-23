package com.expt.Expt_SoftwareEngineer.interceptors;

import com.expt.Expt_SoftwareEngineer.utils.JwtUtil;
import com.expt.Expt_SoftwareEngineer.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull Object handler) {
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
    public void afterCompletion(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler, Exception ex) {
        // 清除 ThreadLocal 中的业务数据
        ThreadLocalUtil.remove();
    }
}
