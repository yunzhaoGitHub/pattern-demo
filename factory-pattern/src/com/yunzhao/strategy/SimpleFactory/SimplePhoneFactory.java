package com.yunzhao.strategy.SimpleFactory;

import com.yunzhao.strategy.product.ApplePhone;
import com.yunzhao.strategy.product.HuawPhone;
import com.yunzhao.strategy.product.MobilePhone;
import com.yunzhao.strategy.product.SumPhone;

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
