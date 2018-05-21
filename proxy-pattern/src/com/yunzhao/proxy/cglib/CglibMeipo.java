package com.yunzhao.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 */
public class CglibMeipo implements MethodInterceptor{


    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 返回cglib代理对象
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        // 业务增强
        System.out.println("我是媒婆：帮你找对象，你想找什么样的");
        methodProxy.invokeSuper(o,objects);
        System.out.println("如果合适的话联系我");
        return null;
    }
}
