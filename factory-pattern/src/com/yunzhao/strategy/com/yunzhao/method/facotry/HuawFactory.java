package com.yunzhao.strategy.com.yunzhao.method.facotry;

import com.yunzhao.strategy.product.HuawPhone;
import com.yunzhao.strategy.product.MobilePhone;

public class HuawFactory implements FactoryInterface{
    @Override
    public MobilePhone getPhone() {
        return new HuawPhone();
    }
}
