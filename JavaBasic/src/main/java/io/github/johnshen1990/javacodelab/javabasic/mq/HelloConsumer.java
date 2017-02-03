package io.github.johnshen1990.javacodelab.javabasic.mq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Author: zhun.shen
 * Date: 2016-12-25 15:42
 * Description:
 */
public class HelloConsumer {
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
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
