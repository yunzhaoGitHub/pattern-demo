package com.yunzhao.SimpleFactory;

import com.yunzhao.product.ApplePhone;
import com.yunzhao.product.HuawPhone;
import com.yunzhao.product.MobilePhone;
import com.yunzhao.product.SumPhone;

public class SimplePhoneFactory {

    public MobilePhone getMobilePhone(String name) {

        if ("三星".equals(name)) {
            return new SumPhone();
        } else if ("苹果".equals(name)) {
            return new ApplePhone();
        } else if ("华为".equals(name)) {
            return new HuawPhone();
        } else {
            return null;
        }
    }
}
