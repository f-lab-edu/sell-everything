package com.souljit2.selleverything.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class SessionCheckInterceptor implements HandlerInterceptor {

    private static final String member = "member";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(member);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}