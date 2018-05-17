package com.yunzhao.SimpleFactory;

import com.yunzhao.product.MobilePhone;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        SimplePhoneFactory simplePhoneFactory = new SimplePhoneFactory();
        System.out.println(simplePhoneFactory.getMobilePhone("华为"));
    }
}
