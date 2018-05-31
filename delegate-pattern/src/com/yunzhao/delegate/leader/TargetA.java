package com.yunzhao.delegate.leader;

public class TargetA implements ITarget {

    @Override
    public void doing(String command) {
        System.out.println("A收到任务执行" + command + "工作");
    }
}
