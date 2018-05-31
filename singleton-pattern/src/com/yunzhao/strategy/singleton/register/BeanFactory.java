package com.yunzhao.strategy.singleton.register;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring中的做法，注册式单例
 */
public class BeanFactory {

    // 私有化构造方法
    private BeanFactory(){}

    // 容器
    private static Map<String, Object> ioc = new HashMap<>();

    public static Object getBean(String className) {

        if (!ioc.containsKey(className)) {
            // 如果容器中没有需要的对象，通过反射创建对象
            Object obj = null;
            try {
                // 通过反射获取对象实例
                obj = Class.forName(className).newInstance();
                // 放到容器中
                ioc.put(className, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ioc.get(className);
    }
}
