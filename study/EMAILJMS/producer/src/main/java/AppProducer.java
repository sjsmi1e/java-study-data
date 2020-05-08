import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午7:28
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@EnableJms
@SpringBootApplication(scanBasePackages = "com.smile")
public class AppProducer extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppProducer.class);
    }

}
