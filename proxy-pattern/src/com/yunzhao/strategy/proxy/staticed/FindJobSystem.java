package com.yunzhao.strategy.proxy.staticed;

/**
 * 静态代理
 */
public class FindJobSystem {

    // 被代理对象的引用
    private Person person;

    // 构造方法
    public FindJobSystem(Person person) {
        this.person = person;
    }

    // 代理方法
    public void helpFindJob() {
        System.out.println("我来帮你找工作，把简历给我");
        person.findJob();
        System.out.println("正在帮你找工作");
    }
}
