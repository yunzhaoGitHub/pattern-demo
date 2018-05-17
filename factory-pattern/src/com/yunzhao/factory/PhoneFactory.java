package com.yunzhao.factory;

import com.yunzhao.product.ApplePhone;
import com.yunzhao.product.HuawPhone;
import com.yunzhao.product.MobilePhone;
import com.yunzhao.product.SumPhone;

public class PhoneFactory extends AbstractFactory {

    @Override
    public MobilePhone getApplePhone() {
        return new ApplePhone();
    }

    @Override
    public MobilePhone getHuawPhone() {
        return new HuawPhone();
    }

    @Override
    public MobilePhone getSumPhone() {
        return new SumPhone();
    }
}
