package com.yunzhao.strategy.payport;

public class Alipay implements Payment{


    @Override
    public Paystatus pay(String uid, double amount) {
        System.out.println("使用阿里支付");
        return new Paystatus(200, "支付成功",amount);
    }
}
