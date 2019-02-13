package com.yhw8930.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication 用于标识一个主程序类,说明当前是Spring Boot项目
@SpringBootApplication
public class HelloMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloMainApplication.class, args);
    }

}
