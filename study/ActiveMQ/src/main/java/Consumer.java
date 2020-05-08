import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-12 下午6:24
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class Consumer {
    private String name = "admin";
    private String passwd = "admin";
    private String url = "tcp://localhost:61616";
    private ConnectionFactory connectionFactory =null;
    private Connection connection = null;
    private Session session = null;
    private MessageConsumer messageConsumer = null;
    private Destination destination;

    public Consumer(){
        connectionFactory = new ActiveMQConnectionFactory(name,passwd,url);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false , Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("first-test");
            messageConsumer = session.createConsumer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void receive(){
        try {
            while (true){
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if(textMessage != null){
                    System.out.println("收到："+textMessage.getText());
                }else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.receive();
    }
}
