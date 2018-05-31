package com.yunzhao.strategy.singleton.lazy;

/**
 * 懒汉式
 * 当需要时才会去创建对象
 * 这种懒汉式是存在线程安全问题的
 */
public class LazySingletonOne {

    // 同样的对构造方法进行私有化
    private LazySingletonOne(){}

    // 静态成员变量
    private static LazySingletonOne lazySingletonOne = null;

    // 对外提供获取实例的静态方法
    public static LazySingletonOne getInstance() {
        // 如果对象没有初始化，就对它进行初始化
        if (lazySingletonOne == null) {
            lazySingletonOne = new LazySingletonOne();
        }
        return lazySingletonOne;
    }

}
