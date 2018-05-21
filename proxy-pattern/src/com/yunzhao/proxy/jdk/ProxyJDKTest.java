package com.yunzhao.proxy.jdk;



public class ProxyJDKTest {

    public static void main(String[] args) {
        ZhongJie zhongJie = new ZhongJie();
        Person obj =(Person) zhongJie.getInstance(new Coder());
        obj.findJob();
    }
}
