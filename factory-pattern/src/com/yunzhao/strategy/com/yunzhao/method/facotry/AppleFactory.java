package com.yunzhao.strategy.com.yunzhao.method.facotry;

import com.yunzhao.strategy.product.ApplePhone;
import com.yunzhao.strategy.product.MobilePhone;

public class AppleFactory implements FactoryInterface{
    @Override
    public MobilePhone getPhone() {
        return new ApplePhone();
    }
}
