package com.fehead.controller;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fehead.controller.viewobject.AskForConfVo;
import com.fehead.controller.viewobject.ConferenceVO;
import com.fehead.error.BusinessException;
import com.fehead.error.EmBusinessError;
import com.fehead.mapper.impl.MessageMapperImpl;
import com.fehead.pojo.*;
import com.fehead.response.CommonReturnType;
import com.fehead.service.*;
import com.fehead.util.JsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2019/1/21 14:34
 * @Created by smile丶
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    UserService userService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ProjectService projectService;
    @Autowired
    FileService fileService;

    String basepath= "/home/fehead/resources/";
    private static String uploadPath="/home/fehead/resources"+ File.separator;
    private static String parentPath="/home/fehead/resources"+ File.separator;

    //用户是否参加了这个会议
    public boolean isUserExitInConf(int user_id,int conf_id){
        List<Conference>conferenceList = conferenceService.getConferenceByUserId(user_id);
        for(Conference conference:conferenceList){
            if(conference.getConfId()==conf_id)
                return true;
        }
        return false;
    }

    @RequestMapping(value = "/init_conf",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public  String addConference(HttpServletResponse response, HttpServletRequest request,
                                 @Param("conf_name")String conf_name,
                                 @Param("conf_org")String conf_org,
                                 @Param("conf_desc")String conf_desc, @Param("confendtime_date")String confendtime_date,
                                 @Param("confendtime_time")String confendtime_time,
                                 @Param("conflinetime_date")String conflinetime_date,
                                 @Param("conf_fee")String conf_fee,
                                 @Param("conflinetime_time")String conflinetime_time,
                                 @Param("conf_location")String conf_location,
                                 @Param("conf_notice")String conf_notice, @Param("confstarttime_date")String confstarttime_date,
                                 @Param("confstarttime_time")String confstarttime_time,
                                 @Param("title")String title, @Param("user_id")int user_id,
                                 @Param("conf_img")String conf_img){

        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //System.out.println("拦截INIT");
        UserInfo userInfo=userService.selectUserById(user_id);
        int conf_id=conferenceService.getLastConf_id()+1;
        //System.out.println(userInfo);
        Double fee = new Double("0.00");
        if (conf_fee!=null){
            fee=Double.valueOf(conf_fee);
        }
            Conference conference=new Conference(conf_id,userInfo,conf_name,confstarttime_date+"."+confstarttime_time,confendtime_date+"."+confendtime_time,conf_location,conf_desc,conf_img,fee,conf_notice,conf_org,conflinetime_date+"."+conflinetime_time);
            //添加会议
            conferenceService.addConference(conference);
            //获得新增会议的ID
            int conf_role_id=conferenceService.getLastConf_id();
            conferenceService.addConferenceRoleInfo(0,conf_role_id,1,"主持人","支持召开会议");
            conferenceService.addConferenceRoleUserInfo(0,user_id,conf_role_id,1);
            //conference 转 json
            return "{\"message\":\"success\"}";

    }


    @RequestMapping(value = "/my_conf",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String byName(HttpServletResponse response, HttpServletRequest request, @Param("user_id")int user_id) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String str = JsonUtil.objectToJson(conferenceService.getConferenceByUserId(user_id));
            //System.out.println(str);
            return str;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }


//    @RequestMapping(value = "/update",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
//    @ResponseBody
//    public String updateUserInfo(HttpServletResponse response, HttpServletRequest request, @Param("user_id")int userId,
//                                 @Param("")){
//        try {
//            request.setCharacterEncoding("utf-8");
//            response.setCharacterEncoding("utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        try {
//            UserInfo userInfo=userService.selectUserById(userId);
//
//            String str = JsonUtil.objectToJson();
//            //System.out.println(str);
//            return str;
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return "{\"message\":\"error\"}";
//        }
//    }


//    /**
//     *
//     * @param response
//     * @param request
//     * @param user_name
//     * @param user_passwor增加用户测试d
//     * @param user_tel
//     * @return
//     */
//    @RequestMapping(value = "/addUser",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
//    @ResponseBody
//    public String addUser(HttpServletResponse response, HttpServletRequest request, @Param("user_name")String user_name,
//                          @Param("user_password")String user_password,@Param("user_tel")String user_tel) {
//        try {
//            request.setCharacterEncoding("utf-8");
//            response.setCharacterEncoding("utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        try {
//            UserInfo userInfo=new UserInfo();
//            userInfo.setUserName(user_name);
//            userInfo.setPassWord(user_password);
//            userInfo.setUserTel(user_tel);
//            userService.addUser(userInfo);
//            String str = JsonUtil.objectToJson(userService.selectUserById(userService.getLastUser_id()));
//            //System.out.println(str);
//            return str;
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return "{\"message\":\"error\"}";
//        }
//    }

    /**
     * 用户申请参加会议
     *String phone_num, String veri_message未实现
     */
    @RequestMapping(value = "/ask_for_conf",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String askForConf(HttpServletResponse response, HttpServletRequest request, @Param("conf_id")int conf_id, @Param("user_id")int user_id,
                             @Param("phone_num")String phone_num, @Param("veri_message")String veri_message,
                             @Param("role_id")int role_id, @Param("desc")String desc) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            if(this.isUserExitInConf(user_id,conf_id)){
                return "{\"message\":\"已经参加会议\"}";
            }
            else {
                //向主持人发送消息。。。。。。
                AskForConfVo askForConfVo = new AskForConfVo(conf_id,user_id,RoleType.getNameByIndex(role_id),desc);
                //加入redis
                userService.addAskConfMessage(String.valueOf(conf_id),String.valueOf(user_id), RoleType.getNameByIndex(role_id),desc);
                //........




//                //websocket向前端推送
//                try {
//                    WebSocketServer.sendInfo("有人请求参加会议",String.valueOf(conferenceService.getMasterIdByconfId(conf_id)));
//                    //WebSocketServer.sendInfo("有人","33");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return "{\"message\":\"error\"}";
//                }
                return "{\"message\":\"已经发送消息\"}";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }

    /**
     * 用户个人信息补全
     * @param response
     * @param request
     * @param user_id
     * @param user_name
     * @param user_sex
     * @param user_age
     * @param user_desc
     * @return
     */
    @RequestMapping(value = "/self_info/update",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public CommonReturnType updateInfo(HttpServletResponse response, HttpServletRequest request,
                             @Param("user_id")String user_id, @Param("user_name")String user_name, @Param("user_sex")String user_sex,
                             @Param("user_age")String user_age, @Param("user_desc")String user_desc) throws BusinessException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        //参数校验
        if (StringUtils.isEmpty(user_id)){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        if (com.fehead.util.StringUtils.isInteger(user_age)||StringUtils.equals(user_sex,"男")||StringUtils.equals(user_sex,"女")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        UserInfo userInfo=userService.selectUserById(Integer.valueOf(user_id));
        if (!user_name.equals(""))
            userInfo.setUserName(user_name);
        if (!user_sex.equals(""))
            userInfo.setUserSex(user_sex);
        if (!user_age.equals(""))
            userInfo.setUserSex(user_age);
        if (!user_desc.equals(""))
            userInfo.setUserDesc(user_desc);
        //System.out.println(userInfo);
        userService.updateUser(userInfo);
        return CommonReturnType.create("success");
    }

    /**
     * 主持人处理用户加入请求
     * @return
     */

    @RequestMapping(value = "/master/manage_asking",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String manageAsking(HttpServletResponse response, HttpServletRequest request,
                               @Param("conf_id")int conf_id, @Param("user_id")int user_id,
                               @Param("asking_id")int asking_id, @Param("is_agree")int is_agree, @Param("role_id")int role_id) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("异常错误");
            return "{\"message\":\"error\"}";
        }
        boolean flag=false;
        String result="";
        //System.out.println(is_agree);
        if(is_agree==1) {//同意
            if(this.isUserExitInConf(asking_id,conf_id))
                result="用户已经参加会议";
            else {
                //新增conference_role_info表
                List<Integer> roleType = conferenceService.getAllRoleTypeByConfid(conf_id);
                boolean isrole=false;
                //判断角色是否已经创建
                for (Integer role:roleType){
                    if(role==role_id){//已经创建
                        isrole=true;
                        break;
                    }
                }
                if(!isrole){
                    conferenceService.addConferenceRoleInfo(0, conf_id,role_id, RoleType.getNameByIndex(role_id), RoleType.getDescByIndex(role_id));
                }
                //新增conference_role_uerinfo表
                conferenceService.addConferenceRoleUserInfo(0,asking_id,conf_id,role_id);
                System.out.println("成功");
                result = "success";
            }
        }
            else {
                result="主持人不同意";
            }
            return "{\"message\":"+"\""+result+"\""+","+
                    "\"conf_id\":"+"\""+conf_id+"\""+","+
                "\"user_id\":"+"\""+user_id+"\""+","+
                "\"is_agree\":"+"\""+is_agree+"\""+"}";
    }

    /**
     * 主持人邀请用户加入
     * @return
     */

    @RequestMapping(value = "/master/invite",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String masterInvite(HttpServletResponse response, HttpServletRequest request,
                               @Param("conf_id")int conf_id, @Param("user_id")int user_id,
                               @Param("asked_user_id")int asked_user_id, @Param("role_id")int role_id, RedirectAttributes attr) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
        //前端验证主持人身份，主持人邀请
            attr.addAttribute("conf_id",conf_id);
            attr.addAttribute("user_id",user_id);
            attr.addAttribute("asking_id",asked_user_id);
            attr.addAttribute("is_agree",1);
            attr.addAttribute("role_id",role_id);
            return "redirect:manage_asking";//重定向到同意申请
    }

    /**
     * 组织者管理用户请求
     * @param response
     * @param request
     * @param conf_id
     * @param user_id
     * @param asking_id
     * @param is_agree
     * @param attr
     * @return
     */
    @RequestMapping(value = "/organizer/manage_asking",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String organizerManageAsking(HttpServletResponse response, HttpServletRequest request,
                                        @Param("conf_id")int conf_id, @Param("user_id")int user_id,
                                        @Param("asking_id")int asking_id, @Param("is_agree")int is_agree, @Param("role_id")int role_id, RedirectAttributes attr) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            //前端验证组织者身份，跳转暂时拥有主持人权限
            attr.addAttribute("conf_id",conf_id);
            attr.addAttribute("user_id",user_id);
            attr.addAttribute("is_agree",is_agree);
            attr.addAttribute("asking_id",asking_id);
            attr.addAttribute("role_id",role_id);
            return "redirect:/user/master/manage_asking";//重定向到master处理申请

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }


    }


    /**
     * 评委查看全体项目信息
     */
    @RequestMapping(value = "/rater/show_project_all",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String organizerManageAsking(HttpServletResponse response, HttpServletRequest request,
                                        @Param("conf_id")int conf_id, @Param("user_id")int user_id) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
        try {
            //前端通过user_id判断是否是评委
            return JsonUtil.objectToJson(projectService.getAllProject(conf_id));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }

    /**
     * 评委通过项目id获得某一项目的详细信息
     */
    @RequestMapping(value = "/rater/show_project_by_id",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String organizerManageAsking(HttpServletResponse response, HttpServletRequest request,
                                        @Param("conf_id")int conf_id, @Param("user_id")int user_id, @Param("pro_id")int pro_id) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
        try {
            //前端通过user_id判断是否是评委
            return JsonUtil.objectToJson(projectService.getPrijectInfoByProjectId(pro_id));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }


    /**
     * 上传
     */
    @RequestMapping(value="/upload",method= RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile, @Param("conf_id") Integer conf_id
            , @Param("user_id") Integer user_id, Model model){
        String uploadPath="/home/fehead/resource/";
        if(multipartFile!=null &&!multipartFile.isEmpty()){
            String originalFilename=multipartFile.getOriginalFilename();
//            String str1=String.valueOf(conf_id);
//            String str2=String.valueOf(user_id);
            String newFileName= com.fehead.util.StringUtils.reName(originalFilename);
            File file=new File(uploadPath+newFileName);
            UserInfo userInfo=userService.selectUserById(user_id);
            FileInfo fileInfo=new FileInfo(0,conf_id,userInfo,uploadPath,newFileName);

            fileService.addFileInfo(fileInfo);
            try {
                multipartFile.transferTo(file);
                model.addAttribute("fileName",newFileName);
                return "{\"message\":\"success\"}";
            } catch (IOException e) {
                e.printStackTrace();
                return "{\"message\":\"fail\"}";
            }
        }
        return "uploadSuc";
    }

    /**
     * 文件下载
     * @throws IOException
     */
    @RequestMapping(value="/download",method= RequestMethod.POST,produces = "text/json;charset=utf-8")
    public void download(@RequestParam(value="filename")String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = "e:/"+filename;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        filename = URLEncoder.encode(filename,"UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }


    /**
     * 主持人查看所有请求加入信息
     *
     *
     */
    @RequestMapping(value = "/master/show_asking",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String askForConf(HttpServletResponse response, HttpServletRequest request, @Param("conf_id")int conf_id, @Param("user_id")int user_id) {
        try {

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            MessageMapperImpl messageMapper=new MessageMapperImpl();
            List<Map<String, String>> messages = messageMapper.getAskConfMessageByConfId(String.valueOf(conf_id));
            return JsonUtil.objectToJson(messages);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }

    /**
     * 主持人查看所有请求加入信息
     *
     *
     */
    @RequestMapping(value = "/organizer/show_asking",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    public String askForConf2(HttpServletResponse response, HttpServletRequest request, @Param("conf_id")int conf_id, @Param("user_id")int user_id, RedirectAttributes attr) {
        try {

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            attr.addAttribute("conf_id",conf_id);
            attr.addAttribute("user_id",user_id);
            return "redirect:/user/master/show_asking";//重定向到同意申请
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }

        public String getDatePoor(Date endDate, Date nowDate) {

            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            // long ns = 1000;
            // 获得两个时间的毫秒时间差异
            long diff = endDate.getTime() - nowDate.getTime();
            // 计算差多少天
            long day = diff / nd;
            // 计算差多少小时
            long hour = diff % nd / nh;
            // 计算差多少分钟
            long min = diff % nd % nh / nm;
            // 计算差多少秒//输出结果
            // long sec = diff % nd % nh % nm / ns;
            return day + "," + hour + "," + min ;
        }

    /**
     * 主持人处理用户的异常事件
     * delay_time:延迟后的时间
     *
     */
    @RequestMapping(value = "/master/manage_delay_info",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String manageDelayInfo(HttpServletResponse response, HttpServletRequest request, @Param("conf_id")int conf_id,
                                  @Param("user_id")int user_id, @Param("asking_user_id")int asking_user_id,
                                  @Param("is_agree")String is_agree, @Param("delay_time")String delay_time) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            if (is_agree.equals("1")){//同意延迟
                //修改conferenceinfo表
                Conference conference = conferenceService.getConferenceById(conf_id);
                String starttime=conference.getConfStarttime();
                String endtime = conference.getConfEndtime();
                System.out.println(starttime);
                System.out.println(endtime);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.HH:mm");
                try {
                    //时间初始化
                    Date start = sdf.parse(starttime);
                    Date end = sdf.parse(endtime);
                    Date delay = sdf.parse(delay_time);
                    String result = getDatePoor(delay,start);
                    String[] days = result.split(",");
//                    for (String s:days)
//                        System.out.println(s);
                    //增加时间
                    Calendar endTime = Calendar.getInstance();
                    endTime.setTime(end);
                    endTime.add(Calendar.DAY_OF_YEAR,Integer.parseInt(days[0]));//日期加天
                    endTime.add(Calendar.HOUR, Integer.parseInt(days[1]));//日期时
                    endTime.add(Calendar.MINUTE, Integer.parseInt(days[2]));//日期分
                    end=endTime.getTime();
                    //时间还原
//                    System.out.println(delay);
//                    System.out.println(end);
                    starttime = sdf.format(delay);
                    endtime = sdf.format(end);
//                    System.out.println(starttime);
//                    System.out.println(endtime);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                conference.setConfStarttime(starttime);
                conference.setConfEndtime(endtime);
                conferenceService.updateConference(conference);
                return "{\"conf_id\":"+conf_id+"," +
                        "\"is_agree\":"+is_agree+"," +
                        "\"delay_time\":"+"\""+delay_time+"\"" +
                        "}";
            }else {//不同意
                return "{\"conf_id\":"+conf_id+"," +
                        "\"is_agree\":"+is_agree +
                        "}";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }

    /**
     * 组织者处理用户的异常事件
     * delay_time:延迟后的时间
     *
     */
    @RequestMapping(value = "/organizer/manage_delay_info",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String organizerManageDelayInfo(HttpServletResponse response, HttpServletRequest request, @Param("conf_id")int conf_id,
                                           @Param("user_id")int user_id, @Param("asking_user_id")int asking_user_id,
                                           @Param("is_agree")String is_agree, @Param("delay_time")String delay_time, RedirectAttributes attr) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //前端验证组织者身份，跳转暂时拥有主持人权限
            System.out.println(is_agree);
            attr.addAttribute("conf_id",conf_id);
            attr.addAttribute("user_id",user_id);
            attr.addAttribute("is_agree",is_agree);
            attr.addAttribute("asking_user_id",asking_user_id);
            attr.addAttribute("delay_time",delay_time);
            return "redirect:/user/master/manage_delay_info";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }

    //评委下载
    @RequestMapping(value="/participant/upload",method= RequestMethod.POST,produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String participantUpload(@RequestParam("file") MultipartFile multipartFile,
                                    @RequestParam("conf_id")int conf_id, @RequestParam("user_id") int user_id, Model model,
                                    @RequestParam("project_name") String proName, @RequestParam("project_desc") String proDesc){
        if(multipartFile!=null &&!multipartFile.isEmpty()){
            String originalFilename=multipartFile.getOriginalFilename();
            String str1=String.valueOf(conf_id);
            String str2=String.valueOf(user_id);
            String newFileName=str1+"_"+str2+"_"+originalFilename;
            File file=new File(uploadPath+newFileName);
            UserInfo userInfo=userService.selectUserById(user_id);
            FileInfo fileInfo=new FileInfo(0,conf_id,userInfo,uploadPath,newFileName);
            fileService.addFileInfo(fileInfo);
            ProjectInfo projectInfo = new ProjectInfo();
            projectInfo.setConfId(conf_id);
            projectInfo.setUserId(userInfo);
            projectInfo.setProjectName(proName);
            projectInfo.setProjectDesc(proDesc);
            FileInfo fileInfo1=fileService.getFileInfoByName(newFileName);
            projectInfo.setFileId(fileInfo1.getFileId());
            projectService.addProjectInfo(projectInfo);
            try {
                multipartFile.transferTo(file);
                model.addAttribute("fileName",newFileName);
                return "{\"message\":\"success\"}";
            } catch (IOException e) {
                e.printStackTrace();
                return "{\"message\":\"fail\"}";
            }
        }
        return "uploadSuc";
    }

    @RequestMapping(value="/rater/down_file",method= RequestMethod.POST,produces = "text/json;charset=utf-8")
    public String raterDownFile(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam("project_id")int project_id,
                                @RequestParam("conf_id")int conf_id, @RequestParam("user_id")int user_id) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        boolean t=false;
        List<Integer> roleIdByconfId_userId = conferenceService.getRoleIdByconfId_UserId(conf_id, user_id);
        for(Integer integer:roleIdByconfId_userId){
            if(integer==3){t=true;}
            break;
        }
        if(t==true){
            ProjectInfo prijectInfoByProjectId = projectService.getPrijectInfoByProjectId(project_id);
            FileInfo fileInfoById = fileService.getFileInfoById(prijectInfoByProjectId.getFileId());
            String filename=fileInfoById.getFileName();
            String path = parentPath + filename;
            //获取输入流
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
            filename = URLEncoder.encode(filename, "UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while ((len = bis.read()) != -1) {
                out.write(len);
                out.flush();
            }
            out.close();
            return "{\"message\":\"下载成功\"}";
        }else{
            return "{\"message\":\"您没有下载权限\"}";
        }
    }

    /**
     * 获取role_id
     */

    @RequestMapping(value = "/get_role",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonReturnType getRole(HttpServletRequest request, HttpServletResponse response, @RequestParam("user_id")String user_id,
                          @RequestParam("conf_id")String conf_id) throws BusinessException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //输入参数判断
        if (StringUtils.isEmpty(user_id)||StringUtils.isEmpty(conf_id)|| !com.fehead.util.StringUtils.isInteger(user_id)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        String role_id =String.valueOf(conferenceService.getRoleIdByconfId_UserId(Integer.valueOf(conf_id),Integer.valueOf(user_id)));
        return CommonReturnType.create(role_id);
    }


    /**
     * 获取可发送消息的会议
     */
    @RequestMapping(value = "/get_right_conference",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonReturnType getRightConference(HttpServletRequest request, HttpServletResponse response, @RequestParam("user_id")String user_id) throws BusinessException {

            response.setCharacterEncoding("UTF-8");
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if(StringUtils.isEmpty(user_id)){
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
            }
            if (!com.fehead.util.StringUtils.isInteger(user_id)){//判断不是整形
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
            }
            List<Integer> conf_ids = conferenceService.getAllRightConferenceIdByUserId(Integer.valueOf(user_id));
            ArrayList<ConferenceVO> conferences = new ArrayList<ConferenceVO>();
            for (Integer i : conf_ids){
                conferences.add(convertFromPojo(conferenceService.getConferenceById(i)));
            }
            return CommonReturnType.create(conferences);
    }

    /**
     * 发送短信消息
     * @param request
     * @param response
     * @param user_id
     * @param conf_id
     * @param notice_data
     * @param smsModelId 短信模板ID，传入的模板必须是在阿里大于“管理中心-短信模板管理”中的可用模板。
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/master/send_notice",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonReturnType sendMessage(HttpServletRequest request, HttpServletResponse response, @RequestParam("user_id")String user_id,
                                        @RequestParam("conf_id") List<Integer> conf_id, @RequestParam("notice_data")String notice_data,
                                        @RequestParam("smsModelId")String smsModelId) throws BusinessException {


            response.setCharacterEncoding("UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (StringUtils.isEmpty(user_id)||StringUtils.isEmpty(notice_data)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        if (!com.fehead.util.StringUtils.isInteger(user_id)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        List<Integer> role_id=new ArrayList<Integer>();
        List<Integer> user_ids=new ArrayList<Integer>();
        boolean issand=false;
        //boolean isallsand=true;
            for (int i:conf_id){
                //判断用户身份（user_id+conf_id）
                role_id = conferenceService.getRoleIdByconfId_UserId(i,Integer.valueOf(user_id));
                for (int role : role_id){
                    if (role==1||role==2){//是主持人或者组织者
                        //此会议发送通知
                        //获取需要发送所有用户id
                        List<UserInfo> users = userService.selectUserIdTelByConfId(i);
                        //System.out.println(users);
                        for (UserInfo u:users){
                            if (u.getUserId()==Integer.valueOf(user_id))
                                continue;
                            //发送短信
                            //public static boolean sendSms(String smsModelId, JSONPObject modelParam, u.getUserTel());
                        }
                        issand=true;
                        break;
                    }else {
                        continue;
                    }
                }

            }
            if (issand)
                return CommonReturnType.create("消息发送成功");
            else
                return CommonReturnType.create("消息发送失败");
    }


    /**
     * 测试websocket
     */
    @RequestMapping(value = "/webtest",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    @ResponseBody
    public void web(HttpServletResponse response, HttpServletRequest request,@RequestParam("user_id")String user_id) throws IOException {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");

        WebSocketServer.sendInfo("youren", user_id);
        System.out.println("发送成功");
    }

    /**
     * 通过user_id获得有权限操作请求的
     *
     */
    @RequestMapping(value = "/get_right_conf",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonReturnType getRightConf(HttpServletResponse response, HttpServletRequest request,@RequestParam("user_id")String user_id) throws IOException, BusinessException {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");

        if (StringUtils.isEmpty(user_id)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        if (!com.fehead.util.StringUtils.isInteger(user_id)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //获取可操作的所有conf_id
        List<Integer> conf_ids = userService.getAllConfIdByUserId_RoleId(Integer.valueOf(user_id));
        List<AskForConfVo> askForConfVos=new ArrayList<AskForConfVo>();

        for (Integer i:conf_ids){
            List<Map<String, String>> messages = userService.getAskConfMessageByConfId(String.valueOf(i));
            for (Map<String,String> info: messages){
                for(String value:info.values()){
                    askForConfVos.add(JsonUtil.jsonToObject(value,AskForConfVo.class));
                }
            }
        }

        return CommonReturnType.create(askForConfVos);

    }






}
