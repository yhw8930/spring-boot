package com.yhw8930.springboot.MyLocaleResolver;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析区域信息
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取自定义解析头信息
        String l = httpServletRequest.getParameter("l");
        //获取浏览器上的区域信息
        Locale locale = httpServletRequest.getLocale();
        //获取系统默认信息
        //Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
