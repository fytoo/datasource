package com.example.datasource.rabbitmq;

import com.example.datasource.datasources.entity.db1.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component

public class HelloSender1 {

    /**

     * AmqpTemplate可以说是RabbitTemplate父类，RabbitTemplate实现类RabbitOperations接口，RabbitOperations继承了AmqpTemplate接口

     */


    @Autowired

    private RabbitTemplate rabbitTemplate1;

    /**

     * 用于单生产者-》单消费者测试

     */

    public void send() {

        String sendMsg = "hello1 " + new Date();

        System.out.println("Sender1 : " + sendMsg);

        this.rabbitTemplate1.convertAndSend("helloQueue", sendMsg);

    }
    public void send1() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setMessageId(UUID.randomUUID().toString());
        messageProperties.setContentType("text/plain");
        messageProperties.setContentEncoding("utf-8");
        Message message = new Message("helloWorld".getBytes(),messageProperties);
        rabbitTemplate1.convertAndSend("exchange", "topic.message",message);
    }
    public void send3(String exchangeName,Message message) {
        rabbitTemplate1.convertAndSend(exchangeName,null, message);
    }
    public void send4() {
        this.rabbitTemplate1.convertAndSend("fanoutExchange",null, "许常乐圣诞节沙迪克哈萨克");
    }
}