package com.controller;

import com.common.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/19.
 */
@RestController
@RequestMapping("/filequire")
public class FileQuireController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E://test//";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public void test1() throws IOException {
        Runtime.getRuntime().exec("cmd /c start D:/新建文件夹/test2007.docx");

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() throws IOException {
        Runtime.getRuntime().exec("cmd /c start D:/新建文件夹/test2007.htm");
    }
}


