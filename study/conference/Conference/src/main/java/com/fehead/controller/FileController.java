package com.fehead.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname FileController
 * @Description TODO
 * @Date 2019/1/22 0022 上午 2:00
 * @Created by Administrator
 */
@RequestMapping(value = "/file",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
@Controller
public class FileController extends BaseController{

    private static String uploadPath="D:"+ File.separator;

    String basepath= "/home/fehead/resources/";

    @RequestMapping("/upload")
    public String upload(@Param("conf_id") int confId, @Param("user_id") int userId, MultipartFile file, Model model){
        MultipartFile multipartFile = file;
        if(multipartFile!=null&&!multipartFile.isEmpty()){
            String originalFilename=multipartFile.getOriginalFilename();
            //获取文件名
            String str2=String.valueOf(userId);
            String str1=String.valueOf(confId);
            String newFileNamePrefix=str1+"_"+str2+"_"+originalFilename;
            System.out.println(newFileNamePrefix);
            //得到新文件名
            String newFileName =newFileNamePrefix+originalFilename.substring(originalFilename.lastIndexOf("."));
            File newfile=new File(uploadPath+newFileName);
            try {
                multipartFile.transferTo(newfile);
                //model.addAttribute("fileName",newFileName);
                return "{\"message\":\"success\"}";
            } catch (IOException e) {
                e.printStackTrace();
                return "{\"message\":\"fail\"}";
            }
        }
        return "uploadSuc";
    }

    private static String parentPath="/home/fehead/resource/";

    @RequestMapping("/down")
    public String down(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        String fileName="会议宝系统设计报告v1.3.doc";
        Path path=Paths.get(parentPath,fileName);
        if(Files.exists(path)){
            String fileSuffix=fileName.substring(fileName.lastIndexOf(".")+1);
            response.setContentType("application/"+fileSuffix);
            try {
                response.addHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                Files.copy(path,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "msg";
    }

    private final ResourceLoader resourceLoader;


    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }



    @RequestMapping(method = RequestMethod.GET, value = "/getImg/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(basepath, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
