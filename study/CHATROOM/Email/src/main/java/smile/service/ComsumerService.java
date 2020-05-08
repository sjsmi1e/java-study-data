package smile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:39
 * @description：${description}
 * @modified By：
 * @version: $version$
 */

@EnableJms
@Service
public class ComsumerService {

    @Autowired
    EmailService emailService;

    @JmsListener(destination = "emailVeri")
    public void getMessageQueue(String msg){
        System.out.println("进入cum");
        System.out.println(msg);
        String[] m = msg.split(",");
        String recName = m[0];
        System.out.println("rec:"+recName);
        String vc = m[1];
        System.out.println("vc:"+vc);
        String message = "<html>\n"+"<body>\n"
                + "<p>您好,你的邮箱验证码为:</p>\n"
                +"<h1>"+vc+"</h1>"
                +"</body>\n"+"</html>";
        emailService.sendEmailHtml(recName,"验证码",message);

    }


}
