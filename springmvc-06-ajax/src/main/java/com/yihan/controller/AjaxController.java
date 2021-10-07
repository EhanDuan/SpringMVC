package com.yihan.controller;

import com.yihan.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a")
    public void a1(String name, HttpServletResponse resp) throws IOException {
        System.out.println("a1:param ->" + name);
        if("yihan".equals(name)){
            resp.getWriter().print("true");
        }else{
            resp.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList= new ArrayList<>();
        //添加数据
        userList.add(new User("yihan", 23,"male"));
        userList.add(new User("kaiZi", 23,"female"));
        userList.add(new User("dogEgg", 23,"male"));

        return userList;

    }
    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "default";
        if(name != null){ // 从数据库中查，这里简写
            if("admin".equals(name)){
                msg="ok";
            }else{
                msg="用户名有误";
            }
        }
        if(pwd != null){
            if("123456".equals(pwd)){
                msg="ok";
            }else{
                msg="密码有误";
            }
        }
        return msg;
    }

}
