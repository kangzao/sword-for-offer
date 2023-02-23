package com.jep.github.designpattern.adapter.loginadapter.adapters;

import com.jep.github.designpattern.adapter.loginadapter.LoginAdapter;
import com.jep.github.designpattern.adapter.loginadapter.ResultMsg;

public class LoginForTelAdapter implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}