package com.yunzhao.proxy.cglib;

public class CglibTest {

    public static void main(String[] args) {
        CglibMeipo cglibMeipo = new CglibMeipo();
        CglibTom obj =(CglibTom) cglibMeipo.getInstance(CglibTom.class);
        System.out.println(obj.getClass());
        obj.findGirl();
    }
}
