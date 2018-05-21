package com.yunzhao.proxy.jdk1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyStudent implements InvocationHandler{

    // 引用代理目标类
    private Student stu;

    // 动态代理
    public Object getInstance(Student stu) {
        this.stu = stu;
        // 获取目标类的字节码文件
        Class<?> clazz = stu.getClass();
        // 产生代理对象
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("多吃蔬菜");
        method.invoke(this.stu, args);
        System.out.println("好吗");
        return null;
    }
}
