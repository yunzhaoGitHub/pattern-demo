package com.yunzhao.strategy.singleton.lazy;

/**
 * 我们已知LazySingletonOne存在着线程安全问题
 * 这种单例模式就是在对外提供的实例方法上加锁，解决了线程安全问题，但是大大降低了效率
 */
public class LazySingletonTwo {

    private LazySingletonTwo() {}

    private static LazySingletonTwo lazySingletonTwo = null;

    public static LazySingletonTwo getInstance() {

        if (lazySingletonTwo == null) {
            synchronized (LazySingletonTwo.class) {
                if (lazySingletonTwo == null) {
                    lazySingletonTwo = new LazySingletonTwo();
                }
            }

        }
        return lazySingletonTwo;
    }

}
