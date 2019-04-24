package com.yhw8930.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {

    @Value("${emp.name}")
    private String name;

    @ResponseBody
    @RequestMapping("/sayHello")
    public String sayHello() {
        return "hello" + name;
    }
}
