package com.yihan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.corba.se.spi.ior.ObjectKey;
import com.yihan.pojo.User;
import com.yihan.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Controller + @ResponseBody
// @RestController
@Controller
public class UserController {
    // deal with chaos encoding error

    // solving by its origin way
//    @RequestMapping(value = "/j1", produces="application/json;charset=utf-8")
    @RequestMapping( "/j1")
    @ResponseBody // it will not be viewed as views for viewResolvers, only return a literal string result
    public String json() throws JsonProcessingException {
        // jackson, objectMapper
        ObjectMapper mapper = new ObjectMapper();

        // create a user
        User user = new User("段依含", 27, "男");
        String str = mapper.writeValueAsString(user);

        return str;

    }

    @RequestMapping( "/j2")
    @ResponseBody // it will not be viewed as views for viewResolvers, only return a literal string result
    public String json2() throws JsonProcessingException {
        // jackson, objectMapper
//        ObjectMapper mapper = new ObjectMapper();

        // create  users
        List<User> list = new ArrayList<>();

        User user = new User("段依含", 27, "男");
        User user2 = new User("段依含2", 27, "男");
        User user3 = new User("段依含3", 27, "男");
        User user4 = new User("段依含4", 27, "男");
        User user5 = new User("段依含5", 27, "男");

        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
//        String str = mapper.writeValueAsString(list);
        return JsonUtils.getJson(list);

    }

    @RequestMapping( "/j3")
    @ResponseBody // it will not be viewed as views for viewResolvers, only return a literal string result
    public String json3() throws JsonProcessingException {
        // jackson, objectMapper
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        //1 自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 2. objectMapper实现格式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(sdf);
        // 默认解析时间是timestamp 1970/1/1到现在的ms
//        return mapper.writeValueAsString(sdf.format(date));
//       也可以调用工具类，复用代码 return JsonUtils.getJson(date, "yyyy-MM-dd HH:mm:ss");
        return mapper.writeValueAsString(date);

    }
}
