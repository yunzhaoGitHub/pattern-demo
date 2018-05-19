package com.yunzhao.prototype.test;

import com.yunzhao.prototype.entity.Hobby;
import com.yunzhao.prototype.entity.Person;
import org.junit.Test;

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
         * [com.yunzhao.prototype.entity.Hobby@78e03bb5,
         * com.yunzhao.prototype.entity.Hobby@5e8c92f4,
         * com.yunzhao.prototype.entity.Hobby@61e4705b,
         * com.yunzhao.prototype.entity.Hobby@50134894]
         *
         *  原对象
         * [com.yunzhao.prototype.entity.Hobby@78e03bb5,
         * com.yunzhao.prototype.entity.Hobby@5e8c92f4,
         * com.yunzhao.prototype.entity.Hobby@61e4705b,
         * com.yunzhao.prototype.entity.Hobby@50134894]
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

        Person copyPerson = person.deepClone(person);
        System.out.println(copyPerson == person);
        System.out.println(copyPerson.getHobbyList());
        System.out.println(person.getHobbyList());
    }

}
