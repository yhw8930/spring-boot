package com.yhw8930.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/excute")
    public String excute(){
        System.out.println();
        return "hello web";
    }

    @RequestMapping("/success")
    public String success(Map<String,String> map){
        map.put("name","zhangsan");
        return "success";
    }
}
