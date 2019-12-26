package com.example.datasource.rabbitmq;

import com.example.datasource.datasources.entity.db1.User;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.transaction.Transactional;
@Component



public class HelloReceiver3 {


    @RabbitHandler
    @RabbitListener(queues = "topic.message")
    public void process(Message  message, Channel channel) {
        System.out.println(message.getMessageProperties().getMessageId());
    }

    @RabbitHandler
    @RabbitListener(queues = "topic.messages")
    @Transactional
    public void process1(Message  message, Channel channel) {
        System.out.println(message.getMessageProperties().getMessageId()+"哈哈哈哈");
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RabbitHandler
    @RabbitListener(queues = "headers_queue")
    public void process2(Message  message) {
        MessageProperties messageProperties = message.getMessageProperties();

        String contentType = messageProperties.getContentType();

        try {
            System.out.println("Receive-Headers:"+new String(message.getBody(), contentType));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void process3(String  msg) {
        System.out.println("fanout.A="+msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void process4(String  msg) {
        System.out.println("fanout.B="+msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void process5(String  msg) {
        System.out.println("fanout.C="+msg);
    }
}