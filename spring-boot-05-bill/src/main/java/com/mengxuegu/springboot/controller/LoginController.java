package com.mengxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 首页登录
 */
@Controller
public class LoginController {
    @PostMapping("/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        //判断用户名不为空并且密码为123，登录成功
        if (!StringUtils.isEmpty(username)&&"123".equals(password)){
            //登陆成功，存入session
            session.setAttribute("loginUser",username);
            //登录成功
            //防止表单重复提交，通过重定向主页，需要添加一个视图
            return "redirect:/main.html";
        }

        map.put("msg","用户名或密码错误");
        return "main/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //清空session
        session.removeAttribute("loginUser");
        //注销session
        session.invalidate();
        //重定向index
        return "redirect:/index.html";
    }
}

