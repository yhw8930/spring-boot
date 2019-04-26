package com.yhw8930.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillController {
    @GetMapping("/bills")
    public String list() {
        //模拟500错误
        int i = 1/0;
        return "bill/list";
    }
}
