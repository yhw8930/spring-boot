package com.yhw8930.springboot.controller;

import com.yhw8930.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
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
    @RequestMapping("/study")
    public String study(Map<String,Object> map , HttpServletRequest request){
        List<User> userList = new ArrayList<>();
        userList.add(new User("小梦",1));
        userList.add(new User("小李",2));
        userList.add(new User("小张",1));
        map.put("userList",userList);
        map.put("sex",1);
        map.put("man",2);

        map.put("desc","欢迎来到<h1>我的测试<h2>");
        //把user对象绑定到session中
        request.getSession().setAttribute("user",new User("李四",1));
        return "study";
    }
}
