package com.yunzhao.strategy.singleton.hungry;

/**
 * 单例模式---饿汉式
 * 所谓饿汉式是指在对象初始化时就创建对象
 *
 * 优点：没有加任何锁，执行效率较高，在用户体验上来讲比懒汉式要好
 * 缺点：类加载时初始化，不管用不用，都占着空间，浪费内存
 *
 * 安全问题：
 * 绝对线程安全，在线程还没出现前就已经初始化了，不存在访问安全问题
 *
 * 类加载顺序
 * 1、先静态，后动态
 * 2、县属性，后方法
 * 3、先上后下
 */
public class HungrySingleton {

    // 初始化成员变量
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    // 提供私有的无参构造
    private HungrySingleton(){}
    // 对外暴露一个可以得到对象实例的方法
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
