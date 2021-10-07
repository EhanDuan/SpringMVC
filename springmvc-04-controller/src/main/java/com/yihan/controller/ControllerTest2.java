package com.yihan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 当 被这个注解的类中的方法返回值为string，且对应着具体的页面，则会被视图解析器解析
public class ControllerTest2 {
    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg", "Controller Test 2");
        return "/test.jsp"; // the name of the view(***.jsp)
    }

    @RequestMapping("/t22")
    public String test3(Model model){
        model.addAttribute("msg", "Controller Test 22");
        return "/test.jsp"; // the name of the view(***.jsp)
    }
}
