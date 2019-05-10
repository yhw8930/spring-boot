package com.yhw8930.springboot.controller;

import com.yhw8930.springboot.entities.User;
import com.yhw8930.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if( !StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) ) {
            //查询数据库用户是否存在
            User user = userMapper.getUserByUsername(username);
            if(user != null && password.equals(user.getPassword())) {
                //登录成功
                session.setAttribute("loginUser", user);
                //重定向 redirect：可以重定向到任意一个请求中（包括其他项目），地址栏改变
                return "redirect:/main.html";
            }
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

