package com.yihan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg", "Hello, my spring mvc annotation program");

        return "hello"; // this is the name of the view, i.e. : hello.jsp
    }
    // 快捷创建新的url
//    @RequestMapping("/hello2")
//    public String hello2(Model model){
//        //封装数据
//        model.addAttribute("msg", "Hello, my spring mvc annotation program");
//
//        return "hello2"; // this is the name of the view, i.e. : hello.jsp
//    }


    // 也可以在class上声明requestmapping， 在方法上也声明，然后拼接url

}
