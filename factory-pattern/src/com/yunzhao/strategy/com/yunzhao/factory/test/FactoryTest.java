package com.yunzhao.strategy.com.yunzhao.factory.test;

import com.yunzhao.strategy.factory.PhoneFactory;

public class FactoryTest {

    public static void main(String[] args) {

        PhoneFactory factory = new PhoneFactory();
        System.out.println(factory.getApplePhone());
        System.out.println(factory.getHuawPhone());
        System.out.println(factory.getSumPhone());
    }
}
