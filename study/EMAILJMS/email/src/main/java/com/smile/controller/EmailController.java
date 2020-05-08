package com.smile.controller;

import com.alibaba.fastjson.JSON;
import com.smile.util.SendEmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午8:49
 * @description：${description}
 * @modified By：
 * @version: $version$
 */


@RestController
@RequestMapping("/send")
public class EmailController {
    @Autowired
    SendEmailUtil sendEmailUtil;

    @RequestMapping("/email")
    public String sendEmai(@RequestParam("recName")String recName,@RequestParam("topic")String topic,@RequestParam("content")String content){
        sendEmailUtil.sendEmail(recName,topic,content);
        return JSON.toJSONString("SUCCESS");
    }


}
