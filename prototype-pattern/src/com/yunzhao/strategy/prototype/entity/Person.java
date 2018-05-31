package com.yunzhao.strategy.prototype.entity;

import java.io.*;
import java.util.List;

public class Person implements Cloneable,Serializable{

    private String name;
    private String gender;
    private List<Hobby> hobbyList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    /**
     * 深克隆
     */
    public Person deepClone() {
        Person copyPerson = null;
        try {
            // 通过流的形式
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream ops = new ObjectOutputStream(bos);
            ops.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            copyPerson = (Person) ois.readObject();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyPerson;
    }
}
