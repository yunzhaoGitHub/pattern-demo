package com.yunzhao.delegate.leader;

public class TargetB implements ITarget {

    @Override
    public void doing(String command) {
        System.out.println("B收到任务执行" + command + "工作");
    }
}
