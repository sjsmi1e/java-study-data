package smile.mapper;

import com.smile.pojo.Email;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:21
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface ProducerMapper {
    public void sendMessage(Email email);

    //public void sendTopic();
}
