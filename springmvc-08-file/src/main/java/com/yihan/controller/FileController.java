package com.yihan.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {
    @PostMapping ("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空，直接回到首页
        if("".equals(uploadFileName)){
            return "redirect:/index/jsp";
        }
        System.out.println("上传文件名：" + uploadFileName);

        // 上传路径保存设置 //引申UUID类
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址是：" + realPath);

        InputStream is = file.getInputStream();//文件输入流
        OutputStream os = new FileOutputStream(new File(realPath, uploadFileName)); // 文件输出流

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1){
            os.write(buffer,0, len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }

    // 利用file.transferTo()上传文件
    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }

        //上传文件地址
        System.out.println("上传文件保存地址"+ realPath);

        //通过CommonsMultipartFile 方法直接写文件
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }
    @RequestMapping("/download")
    public String downloads(HttpServletResponse response, HttpServletRequest request) throws Exception {
        // 要下载的图片地址
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "abc.png";


        //1. 设置response 响应头
        response.reset();//设置页面不缓存，清空buffer
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        //设置响应头
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);
        // 2.读取文件 -- 输入流
        InputStream input = new FileInputStream(file);
        // 3.写出文件--输出留
        OutputStream out = response.getOutputStream();

        byte[] buff = new byte[1024];
        int index = 0;
        // 4.执行写出操作
        while((index = input.read(buff)) != -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }
}
