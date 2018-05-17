package com.yunzhao.com.yunzhao.method.facotry;

import com.yunzhao.product.ApplePhone;
import com.yunzhao.product.HuawPhone;
import com.yunzhao.product.MobilePhone;

public class HuawFactory implements FactoryInterface{
    @Override
    public MobilePhone getPhone() {
        return new HuawPhone();
    }
}
