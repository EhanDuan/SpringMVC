package com.yihan.controller;

import com.yihan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    // localhost:$moduleName/8080/user/t1?name=xxx;
    @GetMapping("/t1")
    public String test1(String name, Model model){
        // 1.接受前端参数
        System.out.println("接受到的前段数据："+ name);
        // 2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        return "/test.jsp";
    }

    //最好加上注解，这样就明确这个是从前端传来的参数
    @GetMapping("/t2")
    public String test2(@RequestParam("name") String name, Model model, HttpSession session){
        // 1.接受前端参数
        System.out.println("接受到的前段数据："+ name);
        // 2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        return "/test.jsp";
    }

    //前端接受一个对象: id, name, age
    // 提交表单的数据匹配对象类中的字段名，如果一致，则ok，否则匹配不到null
    // http://localhost:8080/springmvc_04_controller_war_exploded/user/t3?name=yihan&id=1&age=27
    @RequestMapping("/t3")
    public String test3(User user){
        System.out.println(user);
        return "/test.jsp";
    }

    //modelmap extends from linkedHashMap
    // most situations, we use model or modelAndView
    @RequestMapping("/t4")
    public String test4(ModelMap modelMap){
        modelMap.addAttribute("msg","modelMap success");
        return "/test.jsp";
    }
}
