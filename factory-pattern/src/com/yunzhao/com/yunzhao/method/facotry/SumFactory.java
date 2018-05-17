package com.yunzhao.com.yunzhao.method.facotry;

import com.yunzhao.product.ApplePhone;
import com.yunzhao.product.MobilePhone;
import com.yunzhao.product.SumPhone;

public class SumFactory implements FactoryInterface{
    @Override
    public MobilePhone getPhone() {
        return new SumPhone();
    }
}
