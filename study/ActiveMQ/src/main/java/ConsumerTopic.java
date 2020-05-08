/**
 * @author ：smile丶
 * @date ：Created in 19-3-12 下午9:10
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.sql.SQLOutput;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-12 下午6:24
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class ConsumerTopic {
    private int id ;
    private String name = "system";
    private String passwd = "manager";
    private String url = "tcp://localhost:61616";
    private ConnectionFactory connectionFactory =null;
    private Connection connection = null;
    private Session session = null;
    private MessageConsumer messageConsumer = null;
    private Topic topic;

    public ConsumerTopic(final int id){
        this.id = id;
        connectionFactory = new ActiveMQConnectionFactory(name,passwd,url);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false , Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("test-topic");
            messageConsumer = session.createConsumer(topic);
            //监听器
            System.out.println(id+"开始监听。。。");
            messageConsumer.setMessageListener(new MessageListener() {
                TextMessage textMessage = null;
                public void onMessage(Message message) {
                    try {
                        textMessage =(TextMessage) message;
                        System.out.println(id+"收到："+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new ConsumerTopic(1);
        new ConsumerTopic(2);
        new ConsumerTopic(3);
    }
}
