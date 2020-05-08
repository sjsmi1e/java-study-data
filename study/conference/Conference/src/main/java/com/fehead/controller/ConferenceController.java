package com.fehead.controller;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fehead.error.BusinessException;
import com.fehead.error.EmBusinessError;
import com.fehead.response.CommonReturnType;
import com.fehead.service.ConferenceService;
import com.fehead.util.JsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @Classname ConferenceController
 * @Description TODO
 * @Date 2019/1/21 0021 上午 10:33
 * @Created by CR
 */
@Controller
@RequestMapping("/conference")
public class ConferenceController extends BaseController{
    @Autowired
    public ConferenceService conferenceService;

    @RequestMapping(value = "/all",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String all(HttpServletResponse response, HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String str = JsonUtil.objectToJson(conferenceService.getAllConference());
            //System.out.println(str);
            return str;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }



    @RequestMapping(value = "/byId",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    @ResponseBody
    public String byId(HttpServletResponse response, HttpServletRequest request, @Param("conf_id") int conf_id) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String str = JsonUtil.objectToJson(conferenceService.getConferenceById(conf_id));
            return str;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }

    @RequestMapping(value = "/byId1",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonReturnType byId1(HttpServletResponse response, HttpServletRequest request, @Param("conf_id") String conf_id) throws BusinessException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if(StringUtils.isEmpty(conf_id)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try {
            int a = new Integer(conf_id);
        }catch(Exception e){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        return CommonReturnType.create((conferenceService.getConferenceById(new Integer(conf_id))));
        }


@RequestMapping(value = "/byName",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
@ResponseBody
    public String byName(HttpServletResponse response, HttpServletRequest request, @Param("conf_name")String conf_name) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(conf_name);
            System.out.println(conferenceService.selectConferenceByName(conf_name));
            String str = JsonUtil.objectToJson(conferenceService.selectConferenceByName(conf_name));
            //System.out.println(str);
            return str;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
    }
}

