package com.xiahe.controller;

import com.xiahe.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登陆状态拦截器
public class StatusIntercept extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User admin = (User) session.getAttribute("admin");
        if (user != null || admin != null) {
            return super.preHandle(request, response, handler);
        }
        response.sendRedirect("/Proxy/front/signin.jsp");
        return false;
    }

}
