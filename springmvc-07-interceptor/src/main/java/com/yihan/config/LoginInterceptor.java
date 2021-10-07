package com.yihan.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // let it go if session has content
        if(session.getAttribute("userLoginInfo") != null ||
                session.getAttribute("userLoginInfo") != ""){
            return true;
        }
        // 在提交的时候不拦截
        // p.s. 这里狂神逻辑有点乱，个人认为应该是判断条件： 正在登录且登录完以后session有内容；或者把这个第一次登录放出去
        // p.s. 主要理解这里的思想
        if(request.getRequestURI().contains("login")){
            return true;
        }

        // 登录页面也会放行
        if(request.getRequestURI().contains("Login")){
            return true;
        }

        // you cannot go
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

}
