package com.yihan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {
//    @RequestMapping("/add")
//    public String test1(int a, int b, Model model){
//        int res = a + b;
//        model.addAttribute("msg", "res:" + res);
//        return "test";
//    }

    // RESTful 风格
//    @RequestMapping(value="/add/{a}/{b}", method=RequestMethod.GET) value works but name does not work
    // 也有@GetMapping @PostMapping @ DeleteMapping @PutMapping
    @RequestMapping(value="/add/{a}/{b}", method=RequestMethod.GET)
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "res:" + res);
        return "/test.jsp";
    }
    @GetMapping("/add2/{a}/{b}")
    public String test3(@PathVariable int a, @PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "Get mapping, res:" + res);
        return "/test.jsp";
    }

    @PostMapping("/add2/{a}/{b}")
    public String test4(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "Post mapping, res:" + res);
        return "/test.jsp";
    }
}
