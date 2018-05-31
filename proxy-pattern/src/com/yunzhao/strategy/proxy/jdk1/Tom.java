package com.yunzhao.strategy.proxy.jdk1;

public class Tom implements Student{

    @Override
    public void study() {

    }

    @Override
    public void eat() {
        System.out.println("只会吃饭睡觉");
    }
}
