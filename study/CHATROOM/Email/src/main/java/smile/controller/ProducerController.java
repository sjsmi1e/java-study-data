package smile.controller;

import com.smile.pojo.Email;
import com.smile.service.EmailService;
import com.smile.service.ProducerService;
import com.smile.service.RedisService;
import com.smile.util.GenerateVC;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:19
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@CrossOrigin(origins = {"*", "null"})
@RestController
public class ProducerController {

    @Autowired
    ProducerService producerService;
    @Autowired
    RedisService redisService;
    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String sendMessage(@RequestParam("email")String email){
        String vc = GenerateVC.generateVC();
        Email e = new Email(email,vc);
        redisService.set(e);
        producerService.sendMessage(e);
        //emailService.sendEmail(email,"验证码",vc);
        return  "{\"message\":\"success\"}";
    }

}
