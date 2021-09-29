package com.jep.github.designpattern.adapter.loginadapter.adapters;

import com.jep.github.designpattern.adapter.loginadapter.LoginAdapter;
import com.jep.github.designpattern.adapter.loginadapter.ResultMsg;

public class LoginForSinaAdapter implements LoginAdapter {

  public boolean support(Object adapter) {
    return adapter instanceof LoginForSinaAdapter;
  }

  public ResultMsg login(String id, Object adapter) {
    return null;
  }
}