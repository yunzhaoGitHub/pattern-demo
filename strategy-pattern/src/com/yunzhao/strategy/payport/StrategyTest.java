package com.yunzhao.strategy.payport;

import com.sun.org.apache.xpath.internal.operations.Or;

public class StrategyTest {

    public static void main(String[] args) {
        Order order = new Order("1","201812312312111",10.12);
        System.out.println(order.pay(PayType.ALI_APY));
    }
}
