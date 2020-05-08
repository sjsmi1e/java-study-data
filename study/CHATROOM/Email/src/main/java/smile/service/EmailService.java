package smile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:58
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    //注入发件人
    @Value("${spring.mail.username}")
    private String username;

    public void sendEmailHtml(String recName,String topic,String con){
        System.out.println(recName);
        MimeMessage message=javaMailSender.createMimeMessage();
        //true表示需要创建一个multipart message
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(username);
            helper.setTo(recName);
            helper.setSubject(topic);
            helper.setText(con,true);
            javaMailSender.send(message);
            System.out.println("html格式邮件发送成功");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("html格式邮件发送失败");
        }
    }






    public void sendEmail(String recName,String topic,String con){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(recName);
        mailMessage.setSubject(topic);
        mailMessage.setText(con);
        javaMailSender.send(mailMessage);
    }

}
