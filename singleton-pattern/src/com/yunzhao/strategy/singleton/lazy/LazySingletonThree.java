package com.yunzhao.strategy.singleton.lazy;

//懒汉式单例
//特点：在外部类被调用的时候内部类才会被加载
//内部类一定是要在方法调用之前初始化
//巧妙地避免了线程安全问题
//这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
public class LazySingletonThree {

    private static boolean initialized = false;

    private LazySingletonThree(){
        synchronized (LazySingletonThree.class){
            if (initialized == false) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已被侵犯");
            }
        }

    }

    //每一个关键字都不是多余的
    //static 是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public static final LazySingletonThree getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    // 内部静态类  默认不加载
    private static class LazyHolder{
        private static final LazySingletonThree LAZY = new LazySingletonThree();
    }
}
