package com.example.datasource.poxy.jdk;

public class TestJdk {
    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new HelloServiceImpl());
        HelloService helloService = (HelloService) myInvocationHandler.newProxyInstance();
        helloService.hello("111111111");
    }
}
