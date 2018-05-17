package com.yunzhao.singleton.hungry;

import java.util.concurrent.CountDownLatch;

/**
 * 饿汉式测试类
 */
public class HungrySingletonTest {

    public static void main(String[] args) {

        // 定义创建100个线程数
        int count = 100;

        // 并发测试CountDownLatch类
        CountDownLatch latch = new CountDownLatch(count);

        // 开始时间
        Long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            // 创建线程
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 阻塞线程 当count=0时释放所有点线程
                        latch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // 获取单例对象
                    HungrySingleton obj = HungrySingleton.getInstance();
                    System.out.println(System.currentTimeMillis() + ":" + obj);
                }
            }.start();
            // 每次释放一个线程
            latch.countDown();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 执行时间
        System.out.println(end - begin);
    }
}
