package com.yunzhao.strategy.payport;

public class Wecatpay implements Payment{


    @Override
    public Paystatus pay(String uid, double amount) {
        System.out.println("使用微信支付支付");
        return new Paystatus(200, "支付成功",amount);
    }
}
