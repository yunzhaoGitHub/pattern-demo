package com.yunzhao.com.yunzhao.method.facotry;

import com.yunzhao.factory.PhoneFactory;
import com.yunzhao.product.ApplePhone;
import com.yunzhao.product.MobilePhone;

public class AppleFactory implements FactoryInterface{
    @Override
    public MobilePhone getPhone() {
        return new ApplePhone();
    }
}
