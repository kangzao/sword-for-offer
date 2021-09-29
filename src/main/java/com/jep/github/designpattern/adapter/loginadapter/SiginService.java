package com.jep.github.designpattern.adapter.loginadapter;

public class SiginService {

  /**
   * 注册方法
   */
  public ResultMsg regist(String username, String password) {
    return new ResultMsg(200, "注册成功", new Member());
  }


  /**
   * 登录的方法
   */
  public ResultMsg login(String username, String password) {
    return null;
  }

}