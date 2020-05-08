package smile.pojo;

import lombok.Data;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:28
 * @description：${description}
 * @modified By：
 * @version: $version$
 */

@Data
public class Email {
    private String email;
    private String veriCode;

    public Email() {
    }

    public Email(String email, String veriCode) {
        this.email = email;
        this.veriCode = veriCode;
    }
}
