package com.yunzhao.factory;

import com.yunzhao.product.MobilePhone;

public abstract class AbstractFactory {

    public abstract MobilePhone getApplePhone();

    public abstract MobilePhone getHuawPhone();

    public abstract MobilePhone getSumPhone();

}
