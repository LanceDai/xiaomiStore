package com.xiaomiStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/echart")
    public String getEchart() {
        return "echartTest";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        if (!file.isEmpty()) {
//            String path = request.getServletContext().getRealPath("WEB-INF/static/image/backgroundImage");
            String path = "D:\\github\\xiaomiStore\\web\\WEB-INF\\static\\image\\test";
            System.out.println(path);
            String filename = "bg.jpg";
            File filePath = new File(path, filename);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            try {
                System.out.println(path + File.separator + filename);
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException ignored) {
            }
        }
        return "ok";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }
}
