package com.yunzhao.delegate.leader;

import java.util.HashMap;
import java.util.Map;

public class Leader implements ITarget {

    // 包含所有员工的引用
    private Map<String, ITarget> targets = new HashMap<String, ITarget>();

    public Leader() {
        targets.put("登录", new TargetA());
        targets.put("注册", new TargetB());
    }

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
