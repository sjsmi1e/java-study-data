import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午5:49
 * @description：${description}
 * @modified By：
 * @version: $version$
 */


@EnableJms
@SpringBootApplication(scanBasePackages = "com.smile")
public class CustomerApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class);
    }

}
