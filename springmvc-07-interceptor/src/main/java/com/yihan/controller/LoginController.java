package com.yihan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    //讲道理应该建一个user类，包含用户名和密码这两个字段，然后进行对比
    // 狂神这里排拦截器错发现， 这个login还没有把内容放心session里面就被拦截了
    public String login(HttpSession session, String username, String password, Model model){
        //把用户的信息存在session中
        session.setAttribute("userLoginInfo", username);
        model.addAttribute("username", username);
        return "main";
    }
    @RequestMapping("/doLogin")
    public String login(){
        return "login";
    }
    //现在没登陆就能进首页，需要添加一个拦截器，登陆之前拦截住
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //建议不要直接销毁session, 关闭浏览器才创建新的session 如果频繁创建session，额外消耗浏览器资源
        //session.invalidate();
        session.removeAttribute("username");
        return "main";
    }

}
