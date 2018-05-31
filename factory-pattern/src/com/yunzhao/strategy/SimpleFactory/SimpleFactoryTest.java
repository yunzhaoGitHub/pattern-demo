package com.yunzhao.strategy.SimpleFactory;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        SimplePhoneFactory simplePhoneFactory = new SimplePhoneFactory();
        System.out.println(simplePhoneFactory.getMobilePhone("华为"));
    }
}
