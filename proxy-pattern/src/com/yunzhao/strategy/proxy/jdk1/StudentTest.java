package com.yunzhao.strategy.proxy.jdk1;


public class StudentTest {

    public static void main(String[] args) {
        ProxyStudent ps = new ProxyStudent();
        Student obj =(Student) ps.getInstance(new Tom());
        obj.eat();

    }
}
