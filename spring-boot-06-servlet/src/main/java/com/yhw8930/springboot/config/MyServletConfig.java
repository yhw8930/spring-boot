package com.yhw8930.springboot.config;

import com.yhw8930.springboot.filter.MyFilter;
import com.yhw8930.springboot.listener.MyListener;
import com.yhw8930.springboot.servlet.HelloServlet;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * 注册Servlet相关组件
 */
@Configuration
public class MyServletConfig {
    /**
     * 注册Servlet组件
     */
    @Bean
    public ServletRegistrationBean helloServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new HelloServlet(), "/hello");
        bean.setLoadOnStartup(1);
        return bean;
    }

    /**
     * 注册Filter组件
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/hello"));
        return bean;
    }

    /**
     * 注册监听器Listener组件
     */
    @Bean
    public ServletListenerRegistrationBean myLitener(){
        return new ServletListenerRegistrationBean(new MyListener());
    }

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer() {
            @Override
            public void customize(WebServerFactory factory) {
                ConfigurableServletWebServerFactory factory1 =
                        (ConfigurableServletWebServerFactory) factory;
                factory1.setPort(8082);
                factory1.setContextPath("/servlet2");
            }
        };
    }
}
