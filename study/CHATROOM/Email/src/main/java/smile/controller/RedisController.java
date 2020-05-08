package smile.controller;

import com.smile.pojo.Email;
import com.smile.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:07
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@CrossOrigin(origins = {"*", "null"})
@Controller
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/get")
    @ResponseBody
    public String get(String email){
        if (redisService.hasKey(email))
            return  "{\"VerificationCode\":\""+redisService.get(email)+"\"}";
        else
            return  "{\"VerificationCode\":\"不存在\"}";
    }

    @RequestMapping("/set")
    @ResponseBody
    public String set(String vc,String email){
        Email e = new Email();
        e.setEmail(email);
        e.setVeriCode(vc);
        redisService.set(e);
        return "success";
    }
}
