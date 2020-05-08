package com.smile.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午8:41
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Component
public class SendEmailUtil {
    //自动注入邮箱发件
    @Autowired
    JavaMailSender mailSender;

    //注入发件人
    @Value("${spring.mail.username}")
    private String username;

    public void sendEmail(String recName,String topic,String con){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(recName);
        mailMessage.setSubject(topic);
        mailMessage.setText(con);
        mailSender.send(mailMessage);
    }

}
