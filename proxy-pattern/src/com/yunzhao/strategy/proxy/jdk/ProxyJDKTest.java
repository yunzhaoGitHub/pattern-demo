package com.yunzhao.strategy.proxy.jdk;



public class ProxyJDKTest {

    public static void main(String[] args) {
        ZhongJie zhongJie = new ZhongJie();
        Person obj =(Person) zhongJie.getInstance(new Coder());
        obj.findJob();
    }
}
