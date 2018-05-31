package com.yunzhao.strategy.payport;

public class Paystatus {

    private int code;
    private Object data;
    private String msg;

    public Paystatus(int code,String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString() {
        return ("支付状态:" + code + "," + msg + ",交易金额:" + data );
    }
}
