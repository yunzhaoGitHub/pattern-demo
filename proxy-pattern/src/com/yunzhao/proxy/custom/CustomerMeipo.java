package com.yunzhao.proxy.custom;

import java.lang.reflect.Method;

public class CustomerMeipo implements MyInvocationHandler{

    //被代理的对象，把引用给保存下来
    private CustomPerson target;

    public Object getInstance(CustomPerson target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();

        //用来生成一个新的对象（字节码重组来实现）
        return MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：我要给你找对象，现在已经拿到你的需求");
        System.out.println("开始物色");

        method.invoke(this.target,args);

        System.out.println("如果合适的话，就准备办事");

        return  null;
    }
}
