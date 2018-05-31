package com.yunzhao.strategy.factory;

import com.yunzhao.strategy.product.ApplePhone;
import com.yunzhao.strategy.product.HuawPhone;
import com.yunzhao.strategy.product.MobilePhone;
import com.yunzhao.strategy.product.SumPhone;

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
