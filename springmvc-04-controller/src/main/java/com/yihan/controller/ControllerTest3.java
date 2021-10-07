package com.yihan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// @RequestMapping 注解可以用于映射url到控制器类或者一个特定的处理程序方法。
// 可以用于类上也可以用于方法上。 类上的路径作为父路径

@Controller

@RequestMapping("/t3")
public class ControllerTest3 {
    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg", "controller 3, test1");
        return "/test.jsp";

    }
}
