package smile.service;

import com.smile.mapper.ProducerMapper;
import com.smile.pojo.Email;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:20
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service
public class ProducerService implements ProducerMapper {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;


    @Override
    public void sendMessage(Email email) {
        //目的地
        Destination destination = new ActiveMQQueue("emailVeri");
        //定义信息
        String[] message =new String[2];
        message[0] = email.getEmail();
        message[1] = email.getVeriCode();
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
