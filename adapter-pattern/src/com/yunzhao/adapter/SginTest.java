package com.yunzhao.adapter;

import com.yunzhao.adapter.result.ResultMsg;
import com.yunzhao.adapter.result.SginForKindsService;

public class SginTest {

    public static void main(String[] args) {

        SginForKindsService sgin = new SginForKindsService();
        ResultMsg resultMsg = sgin.loginForQQ("HJOIHKJHJKHIUHIU&^*&^&*%&^%");
        System.out.println(resultMsg.getCode());
        System.out.println(resultMsg.getMsg());
    }
}
