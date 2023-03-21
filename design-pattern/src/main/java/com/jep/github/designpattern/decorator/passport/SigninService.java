package com.jep.github.designpattern.decorator.passport;

public class SigninService implements ISigninService {


  @Override
  public ResultMsg regist(String username, String password) {
    return new ResultMsg(200, "注册成功", new Member());
  }

  @Override
  public ResultMsg login(String username, String password) {
    return null;
  }
}