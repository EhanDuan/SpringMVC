package com.yihan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        System.out.println(session);
        return "hello";
    }

//    // 注掉视图解析器，可以用原生态的方法，如以下，实际借用了req.getRequestDispatcher().forward(req, resp)
//    @RequestMapping("/m1/t11")
//    public String test1(){
//        //转发一
//        return "/index.jsp"; //包含了"/"即默认为转发
//    }
//
//    @RequestMapping("/m1/t22")
//    public String test2(){
//        //转发二，显式转发
//        return "forward:/index.jsp";
//    }
//
//    public String test3(){
        //重定向
//        return "redirect:/index.jsp"; redirect 也可以被正确识别when 视图解析器被注册的时候
//    }

}
