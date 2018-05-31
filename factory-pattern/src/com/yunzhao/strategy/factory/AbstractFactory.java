package com.yunzhao.strategy.factory;

import com.yunzhao.strategy.product.MobilePhone;

public abstract class AbstractFactory {

    public abstract MobilePhone getApplePhone();

    public abstract MobilePhone getHuawPhone();

    public abstract MobilePhone getSumPhone();

}
