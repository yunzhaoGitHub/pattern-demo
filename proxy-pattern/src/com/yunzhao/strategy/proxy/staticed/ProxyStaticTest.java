package com.yunzhao.strategy.proxy.staticed;

public class ProxyStaticTest {

    public static void main(String[] args) {
        FindJobSystem fjs = new FindJobSystem(new Person("小王"));
        fjs.helpFindJob();
    }
}
