package com.yunzhao.strategy.payport;

public enum PayType {
    ALI_APY(new Alipay()),
    WECAT_PAY(new Wecatpay()),
    JD_PAY(new JDpay());

    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get(){
        return this.payment;
    }
}
