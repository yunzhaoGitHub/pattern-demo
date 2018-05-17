package com.yunzhao.singleton.lazy;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

public class SingletonTest {


    /**
     *   这里同样适用CountDownLatch对懒汉式1进行一个并发测试
     *   1526568380827:com.yunzhao.singleton.lazy.LazySingletonOne@5224f714
     *   1526568380827:com.yunzhao.singleton.lazy.LazySingletonOne@20210b0
     *
     *   1526568712257:com.yunzhao.singleton.lazy.LazySingletonOne@6cc329b7
     *   1526568712257:com.yunzhao.singleton.lazy.LazySingletonOne@b980947
     *   可以看到当并发访问时 它并不安全
     *
     *   26ms
     *
     */
    @Test
    public void testLazySingletonOne() {
        int count = 300;

        CountDownLatch latch = new CountDownLatch(count);
        Long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            // 获取100个线程，并阻塞
            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 获取单例对象
                    LazySingletonOne obj = LazySingletonOne.getInstance();
                    System.out.println(System.currentTimeMillis() + ":" + obj);
                }
            }.start();
            // 每创建一个线程count-- 当count=0时执行
            latch.countDown();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 67ms
     * 加锁之后明显效率变低，但是毫无疑问他是线程安全的
     */
    @Test
    public void testLazySingletonTwo() {
        int count = 300;

        CountDownLatch latch = new CountDownLatch(count);
        Long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            // 获取100个线程，并阻塞
            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 获取单例对象
                    LazySingletonTwo obj = LazySingletonTwo.getInstance();
                    System.out.println(System.currentTimeMillis() + ":" + obj);
                }
            }.start();
            // 每创建一个线程count-- 当count=0时执行
            latch.countDown();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 尝试使用暴力反射破解
     */
    @Test
    public void testLazySingletonThree(){

        // 获取字节码文件
        Class<?> clazz = LazySingletonThree.class;
        // 通过反射获取私有构造方法
        try {
            Constructor constructor = clazz.getDeclaredConstructor(null);
            // 强制访问
            constructor.setAccessible(true);
            // 暴力初始化
            Object obj1 = constructor.newInstance();
            // 调用两次构造方法，相当于new两次
            Object obj2 = constructor.newInstance();
            Object obj3 = constructor.newInstance();
            System.out.println(obj1);
            System.out.println(obj2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
