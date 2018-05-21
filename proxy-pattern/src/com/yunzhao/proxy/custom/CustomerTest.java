package com.yunzhao.proxy.custom;

public class CustomerTest {

    public static void main(String[] args) {

        try {
            CustomerMeipo customerMeipo = new CustomerMeipo();
            CustomPerson obj =(CustomPerson) customerMeipo.getInstance(new Yunzhao());
            obj.findGirlFriend();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
