package com.yunzhao.strategy.prototype.test;

import com.yunzhao.strategy.prototype.entity.Hobby;
import com.yunzhao.strategy.prototype.entity.Person;
import com.yunzhao.strategy.prototype.entity.Student1;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 克隆测试类
 */
public class CloneTest {

    @Test
    public void testClone() throws CloneNotSupportedException {
        Person person = new Person();
        person.setGender("男");
        person.setName("张三");
        // list
        List<Hobby> hobbyList = new ArrayList<Hobby>();
        Hobby hobby1 = new Hobby("田径", "2");
        Hobby hobby2 = new Hobby("射击", "1");
        Hobby hobby3 = new Hobby("骑马", "3");
        Hobby hobby4 = new Hobby("游泳", "4");
        hobbyList.add(hobby1);
        hobbyList.add(hobby2);
        hobbyList.add(hobby3);
        hobbyList.add(hobby4);
        person.setHobbyList(hobbyList);

        /*
         * 测试浅克隆
         *  浅克隆获得的对象
         * [Hobby@78e03bb5,
         * Hobby@5e8c92f4,
         * Hobby@61e4705b,
         * Hobby@50134894]
         *
         *  原对象
         * [Hobby@78e03bb5,
         * Hobby@5e8c92f4,
         * Hobby@61e4705b,
         * Hobby@50134894]
         *
         * 可以得到的结论是
         * 浅克隆对于基本类型的成员变量来说是可以克隆的
         * 但是对于引用数据类型比如List集合中的对象，只是简单的克隆了地址的引用
         * 同时这也意味着，当其中某个对象发生改变时，两个对象中的变量都会随之改变
         */
        Person clonePerson = (Person) person.clone();
        System.out.println(clonePerson.getHobbyList());
        System.out.println(person.getHobbyList());
        System.out.println(clonePerson.getHobbyList() == person.getHobbyList());
    }

    /**
     * 测试深克隆
     * 通过io的方式克隆了新的对象，这两个对象时完全独立的  互不干扰
     * @throws CloneNotSupportedException
     */
    @Test
    public void testDeepClone() throws CloneNotSupportedException {
        Person person = new Person();
        person.setGender("男");
        person.setName("张三");
        // list
        List<Hobby> hobbyList = new ArrayList<Hobby>();
        Hobby hobby1 = new Hobby("田径", "2");
        Hobby hobby2 = new Hobby("射击", "1");
        Hobby hobby3 = new Hobby("骑马", "3");
        Hobby hobby4 = new Hobby("游泳", "4");
        hobbyList.add(hobby1);
        hobbyList.add(hobby2);
        hobbyList.add(hobby3);
        hobbyList.add(hobby4);
        person.setHobbyList(hobbyList);

        Person copyPerson = person.deepClone();
        System.out.println(copyPerson == person);
        System.out.println(copyPerson.getHobbyList());
        System.out.println(person.getHobbyList());
    }

    /*
     * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
     *
     * 1.获取构造方法：
     *      1).批量的方法：
     *          public Constructor[] getConstructors()：所有"公有的"构造方法
                public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

     *      2).获取单个的方法，并调用：
     *          public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
     *          public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
     *
     *          调用构造方法：
     *          Constructor-->newInstance(Object... initargs)
     */
    @Test
    public void testReflect() throws Exception {

        Class<?> clazz = Class.forName("com.yunzhao.strategy.prototype.entity.Student");

        //获取所有共有构造
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor contructor : constructors) {
            System.out.println(contructor);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        Constructor<?>[] conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。

        System.out.println("con = " + con);
        //调用构造方法
        Object obj = con.newInstance();
        //  System.out.println("obj = " + obj);
        //  Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance('男');

    }

    /*
     * 获取成员变量并调用：
     *
     * 1.批量的
     *      1).Field[] getFields():获取所有的"公有字段"
     *      2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * 2.获取单个的：
     *      1).public Field getField(String fieldName):获取某个"公有的"字段；
     *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     *
     *   设置字段的值：
     *      Field --> public void set(Object obj,Object value):
     *                  参数说明：
     *                  1.obj:要设置的字段所在的对象；
     *                  2.value:要为字段设置的值；
     *
     */
    @Test
    public void testParams() throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("com.yunzhao.strategy.prototype.entity.Student1");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }

        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = stuClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student1 stu = (Student1)obj;
        System.out.println("验证姓名：" + stu.name);


        System.out.println("**************获取私有字段****并调用********************************");
        f = stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888889999");
        System.out.println("验证电话：" + stu);
    }
}
