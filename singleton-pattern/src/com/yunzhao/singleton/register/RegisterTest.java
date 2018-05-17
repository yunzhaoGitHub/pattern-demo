package com.yunzhao.singleton.register;

import com.yunzhao.singleton.lazy.LazySingletonTwo;
import org.junit.Test;

import java.lang.Enum;
import java.util.concurrent.CountDownLatch;

public class RegisterTest {

    @Test
    public void testRegisterSingleton() {
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
                    RegisterSingleton obj = RegisterSingleton.getInstance("RegisterSingleton");
                    System.out.println(System.currentTimeMillis() + ":" + obj);
                }
            }.start();
            // 每创建一个线程count-- 当count=0时执行
            latch.countDown();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void testEnum(){

    }
}
