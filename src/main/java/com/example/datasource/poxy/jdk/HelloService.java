package com.example.datasource.poxy.jdk;

// 抽象主题角色
public interface HelloService {

    String hello(String name);

    String hi(String msg);
}

// 具体(真实)主题角色
class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String hi(String msg) {
        return "Hi, " + msg;
    }
}