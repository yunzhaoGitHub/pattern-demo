package com.yunzhao.strategy.proxy.custom;


public class Yunzhao implements CustomPerson {

    @Override
    public void eat() {
        System.out.println("我在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("我在睡觉");
    }

    @Override
    public void findGirlFriend() {
        System.out.println("找个白富美");
    }
}
