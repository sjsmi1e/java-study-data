import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-12 下午5:50
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class Producer {
    private String name = "smile" ;
    private String passwd = "789396";
    private String url = "tcp://localhost:61616";

    //连接工厂
    private ConnectionFactory connectionFactory = null;
    //连接
    private Connection connection = null;
    //会话
    private Session session = null;
    //目的地
    private Destination destination = null;
    //消息生产者
    private MessageProducer messageProducer = null;

    public Producer(){
        //连接实例
        connectionFactory = new ActiveMQConnectionFactory(name,passwd,url);
        try {
            //连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //创建消息队列
            destination = session.createQueue("first-test");
            //创建消息生产者
            messageProducer = session.createProducer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    //发送消息
    public void sendMessage(){
        TextMessage textMessage = null;
        for (int i = 0;i<10;i++){
            try {
                textMessage = session.createTextMessage("消息测试："+i);
                messageProducer.send(textMessage);
                System.out.println("发送成功:"+i);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        try {
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.sendMessage();
    }

}
