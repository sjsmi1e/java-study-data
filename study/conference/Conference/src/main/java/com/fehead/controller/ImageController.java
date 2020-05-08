package com.fehead.controller;

import com.fehead.response.CommonReturnType;
import com.fehead.service.ConferenceService;
import com.fehead.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Conference
 * @description: 图像拦截器
 * @author: smile丶
 * @create: 2019-02-20 18:10
 **/

@Controller
@RequestMapping("/imgs")
public class ImageController extends BaseController{
    @Autowired
    UserService userService;
    @Autowired
    ConferenceService conferenceService;

    String basepath= "/home/fehead/resources/";

    /**
     * 上传图片
     *
     *
     */

    //获取当前日期时间的string类型用于文件名防重复
    public String dates(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    //文件上传返回地址
    public String upimg(MultipartFile multipartFile, String uptype) throws IOException {
            //获取文件名
            String originalFilename = multipartFile.getName();
            //获取新文件名
            String newFileName= com.fehead.util.StringUtils.reName(originalFilename);
            File file  =  new File(basepath+newFileName);
            //上传文件
            multipartFile.transferTo(file);
            //将图片在项目中的地址和isok状态储存为json格式返回给前台，由于公司项目中没有fastjson只能用这个
            String address = "http://47.92.194.26/conference/file/getImg/"+newFileName;
            return address;
        }
    /**
     * url  /imgs/upload_img
     * @param request
     * @param response
     * @return 图片服务器地址json
     * @throws Exception
     */
    @RequestMapping(value = "/upload_img",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonReturnType uploadPicture1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        String address = upimg(multipartFile,"conference");
        return CommonReturnType.create(address);
    }

//    /**
//     *
//     * @param request
//     * @param response
//     * @return 图片服务器地址
//     * @throws Exception
//     */
//    @RequestMapping("/wx_upload_user")
//    @ResponseBody
//    public CommonReturnType uploadPicture2(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //获取从前台传过来得图片
//        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
//        MultipartFile multipartFile =  req.getFile("file");
//        String address = upimg(multipartFile,"user");
//        return JsonUtil.objectToJson(address);
//    }

}
