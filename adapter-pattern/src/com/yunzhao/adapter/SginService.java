package com.yunzhao.adapter;

import com.yunzhao.adapter.result.Member;
import com.yunzhao.adapter.result.ResultMsg;

public class SginService {

    public ResultMsg register(String username, String password){
        return new ResultMsg("200","注册成功", new Member());
    }

    public ResultMsg login(String username, String password){
        return new ResultMsg("200","登录成功", new Member());
    }
}
