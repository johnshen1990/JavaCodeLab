package io.github.johnshen1990.javacodelab.javabasic.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * Author: zhun.shen
 * Date: 2016-12-25 15:42
 * Description:
 */
public class HelloProducer {
    private static final String HOST = "23.106.137.141";
    private static final String QUEUE_NAME = "hello_queue";
    private static final String USERNAME = "john";
    private static final String PASSWORD = "changeit";


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Fuck you!!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

}
