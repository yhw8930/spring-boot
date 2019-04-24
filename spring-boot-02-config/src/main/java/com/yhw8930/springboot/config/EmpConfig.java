package com.yhw8930.springboot.config;

import com.yhw8930.springboot.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration表示这是一个配置类，用来表示对应的spring配置文件
@Configuration
public class EmpConfig {
    /**
     * @return 注入容器中的组件对象
     * @Bean 标识方法用于向容器注入组件
     * 方法名为组件的id值
     */
    @Bean
    public EmpService empService2() {
        System.out.println("注解已经将 EmpService 组件注入");
        return new EmpService();
    }
}
