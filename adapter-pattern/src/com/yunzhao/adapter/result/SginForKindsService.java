package com.yunzhao.adapter.result;

import com.yunzhao.adapter.SginService;

public class SginForKindsService extends SginService {


    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）
        //4、调用原来的登录方法

        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWechat(String openId){

        return null;
    }

    public ResultMsg loginForPhone(String openId){

        return null;
    }

    public ResultMsg loginForRegist(String username, String password){
        super.register(username,password);
        return super.login(username,password);
    }
}
