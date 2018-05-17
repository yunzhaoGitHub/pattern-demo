package com.yunzhao.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterSingleton {

    // 私有化构造方法
    private RegisterSingleton(){}

    // Map容器 --保证线程安全
    private static Map<String, Object> map = new ConcurrentHashMap<>();

    public static RegisterSingleton getInstance(String className){

       if (className == null) {
           className = RegisterSingleton.class.getName();
       }
       if (map.get(className) == null) {
           map.put(className, new RegisterSingleton());
       }
        return (RegisterSingleton) map.get(className);
    }
}
