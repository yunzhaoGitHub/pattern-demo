package com.yunzhao.proxy.staticed;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void findJob() {
        System.out.println(name + "想要找工作");
    }
}
