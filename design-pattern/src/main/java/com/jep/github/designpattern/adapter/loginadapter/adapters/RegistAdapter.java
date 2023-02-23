package com.jep.github.designpattern.adapter.loginadapter.adapters;

import com.jep.github.designpattern.adapter.loginadapter.ResultMsg;

public interface RegistAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}