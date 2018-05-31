package com.yunzhao.strategy.proxy.custom;

public class CustomerTest {

    public static void main(String[] args) {

        try {
            CustomerMeipo customerMeipo = new CustomerMeipo();
            CustomPerson obj =(CustomPerson) customerMeipo.getInstance(new Yunzhao());
            obj.findGirlFriend();
            obj.eat();
            obj.sleep();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
