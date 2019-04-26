package com.yhw8930.springboot.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //调用目标方法之前被拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        System.out.println(loginUser);
        if (!StringUtils.isEmpty(loginUser)) {
            //已登录，请放行
            return true;
        }
        //未登录, 转发到登录页面
        request.setAttribute("msg", "无权限，请登录后访问！");
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;
    }
}
