package com.yunzhao.strategy.payport;

public class Order {

    private String oid;
    private String orderId;
    private double amount;

    public Order(String oid, String orderId, double amount) {
        this.oid = oid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Paystatus pay(PayType payType) {
        return payType.get().pay(oid, amount);
    }
}
