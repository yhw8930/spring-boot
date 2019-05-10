package com.yhw8930.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义Filter
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化操作..");
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter过滤完成...");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
