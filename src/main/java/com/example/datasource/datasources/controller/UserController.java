package com.example.datasource.datasources.controller;

import com.example.datasource.datasources.entity.db1.User;
import com.example.datasource.datasources.service.UserService;
import com.example.datasource.rabbitmq.HelloSender1;
import com.example.datasource.redis.CityInfo;
import com.example.datasource.redis.CityService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
 
    @Autowired
    private UserService userService;
    @Autowired
    private CityService cityService;
    @Autowired
    private com.example.datasource.rabbitmq.HelloSender1 HelloSender1;
 
    @GetMapping("/select/list")
    public CityInfo selectUserList() {
        return  cityService.getCity(1,"12");
    }
 
    @GetMapping("/save")
    public void saveUser(User user) {
        this.cityService.addCity(1,"13");
    }
    @GetMapping("/delete")
    public void delete() {
        this.cityService.delete(1);
    }

    @PostMapping(value="/getException" ,produces = "application/json;charset=UTF-8")
    public String getException(@Valid @RequestBody User user) {
        System.out.println(user.getName());
        return  "validate1";
    }
    @GetMapping(value="/rabbitmq1" )
    public void rabbitmq1() {
        HelloSender1.send();
    }
    @GetMapping(value="/rabbitUsermq1" )
    public void rabbitUsermq1() {

        HelloSender1.send1();
    }
    @GetMapping(value="/rabbitUsermq2" )
    public void rabbitUsermq2() {
        Map<String, Object> map_all = new HashMap<>();
        map_all.put("Two", "B");
        /*map_all.put("Two", "B");*/

        /**
         * 声明消息 (消息体, 消息属性)
         */
        MessageProperties messageProperties = new MessageProperties();
        // 设置消息是否持久化。Persistent表示持久化，Non-persistent表示不持久化
        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        messageProperties.setContentType("UTF-8");
        messageProperties.getHeaders().putAll(map_all);

        Message message = new Message("许常乐打算后端！".getBytes(), messageProperties);

        HelloSender1.send3("headers_exchange", message);
    }
    @GetMapping(value="/rabbitUsermq4" )
    public void rabbitUsermq4() {
        HelloSender1.send4();
    }

}