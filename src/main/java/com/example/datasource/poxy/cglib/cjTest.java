package com.example.datasource.poxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class cjTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Chinese.class);
        enhancer.setCallback(new ChinesePoxy());
        Chinese chinese= (Chinese) enhancer.create();
        chinese.sayHello();
    }
}
