package com.yunzhao.strategy.com.yunzhao.method.facotry;

public class MethodFactoryTest {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        System.out.println(appleFactory.getPhone());
    }
}
