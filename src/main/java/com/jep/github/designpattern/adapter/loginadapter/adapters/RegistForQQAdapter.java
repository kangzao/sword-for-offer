package com.jep.github.designpattern.adapter.loginadapter.adapters;

import com.jep.github.designpattern.adapter.loginadapter.LoginAdapter;
import com.jep.github.designpattern.adapter.loginadapter.ResultMsg;

public class RegistForQQAdapter implements RegistAdapter, LoginAdapter {

  public boolean support(Object adapter) {
    return false;
  }

  public ResultMsg login(String id, Object adapter) {
    return null;
  }
}