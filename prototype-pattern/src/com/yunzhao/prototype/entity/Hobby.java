package com.yunzhao.prototype.entity;

import java.io.Serializable;

public class Hobby implements Cloneable, Serializable{

    private String hobbyName;
    private String times;

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Hobby(String hobbyName, String times) {
        this.hobbyName = hobbyName;
        this.times = times;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
