package smile.controller;

import com.smile.util.MailValid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-16 下午4:27
 * @description：${description}
 * @modified By：
 * @version: $version$
 */

@RequestMapping("/email")
@RestController
public class EmailController {

    @RequestMapping("/isval")
    public String emailIsVal(String email){
        if (MailValid.valid(email, "jootmir.org"))
            return  "{\"message\":\"success\"}";
        else
            return  "{\"message\":\"error\"}";
    }
}
