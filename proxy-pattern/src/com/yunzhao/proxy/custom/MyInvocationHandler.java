package com.yunzhao.proxy.custom;

import java.lang.reflect.Method;

public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}