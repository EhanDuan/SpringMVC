package com.yihan.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.naming.ldap.Control;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // model and view
        ModelAndView mv = new ModelAndView();

        //封装对象，放在modelAndView中，
        mv.addObject("msg", "HelloSpringMVC!");
        // 封装要跳转的视图，放在modelandView中
        mv.setViewName("hello"); // WEB-INF/jsp/hello.jsp
        return mv;
    }
}
