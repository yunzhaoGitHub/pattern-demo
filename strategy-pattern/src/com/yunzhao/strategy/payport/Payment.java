package com.yunzhao.strategy.payport;

public interface Payment {

    public Paystatus pay(String uid, double amount);
}
