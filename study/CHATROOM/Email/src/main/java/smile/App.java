package smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:10
 * @description：${description}
 * @modified By：
 * @version: $version$
 */

@SpringBootApplication(scanBasePackages = "com.smile")
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
