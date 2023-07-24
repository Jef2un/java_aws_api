package com.jeffnalex.interceptor;

import com.jeffnalex.constant.ErrorMsgConstant;
import com.jeffnalex.context.BaseContext;
import com.jeffnalex.result.Result;
import com.jeffnalex.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 從header中取得token
        String token = request.getHeader("token");
        // 驗證token
        try {
            Claims claims = JwtUtil.parseJWT(token);
            Long empId = Long.valueOf(claims.get("id").toString()) ;
            BaseContext.setCurrentId(empId);
        } catch(Exception ex){
            ex.printStackTrace();
            response.setStatus(401);
            return false;
        }

        return true;

    }

}
