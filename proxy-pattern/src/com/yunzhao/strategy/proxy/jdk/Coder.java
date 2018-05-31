package com.yunzhao.strategy.proxy.jdk;

public class Coder implements Person {

    @Override
    public void findJob() {
        System.out.println("我想找工作");
    }
}
