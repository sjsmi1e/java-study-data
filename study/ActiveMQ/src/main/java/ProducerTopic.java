import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-12 下午9:10
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class ProducerTopic {
    private String name = "system";
    private String passwd = "manager";
    private String url = "tcp://localhost:61616";

    private ConnectionFactory connectionFactory = null;
    private Connection connection = null;
    private Session session = null;
    private Topic topic = null;
    private MessageProducer messageProducer = null;

    public ProducerTopic(){
        connectionFactory = new ActiveMQConnectionFactory(name,passwd,url);

        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("test-topic");
            messageProducer = session.createProducer(topic);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//不将数据持久化
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(){
        TextMessage textMessage = null;
        for (int i=1;i<=10;i++){
            try {
                textMessage = session.createTextMessage("topic:"+i);
                messageProducer.send(textMessage);
                System.out.println("发送成功："+i);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        try {
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerTopic producerTopic = new ProducerTopic();
        producerTopic.sendMessage();
    }

}
