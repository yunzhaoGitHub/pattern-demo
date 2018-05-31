package com.yunzhao.strategy.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ZhongJie implements InvocationHandler{

    // 引用代理目标
    private Person target;

    // 实例化
    public Object getInstance(Person target) {
        this.target = target;
        
        // 获取字节码文件
        Class<?> clazz = target.getClass();

        // 生成新的对象
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始帮你投简历了");
        method.invoke(this.target, args);
        System.out.println("物色工作中");
        return null;
    }
}
