package com.yunzhao.strategy.payport;

public class JDpay implements Payment{


    @Override
    public Paystatus pay(String uid, double amount) {
        System.out.println("使用京东支付");
        return new Paystatus(200, "支付成功",amount);
    }
}
