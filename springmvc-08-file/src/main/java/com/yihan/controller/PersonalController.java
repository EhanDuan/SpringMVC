package com.yihan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {
    @RequestMapping("/personal")
    public String test(){
        return "personal";
    }
}
