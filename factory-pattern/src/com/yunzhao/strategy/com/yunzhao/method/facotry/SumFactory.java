package com.yunzhao.strategy.com.yunzhao.method.facotry;

import com.yunzhao.strategy.product.MobilePhone;
import com.yunzhao.strategy.product.SumPhone;

public class SumFactory implements FactoryInterface{
    @Override
    public MobilePhone getPhone() {
        return new SumPhone();
    }
}
