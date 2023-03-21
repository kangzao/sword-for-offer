package com.jep.github.designpattern.decorator.passport;

/*
 * @author: enping.jep
 * @create: 2023-03-21 7:11 PM
 * 第三方登录自由适配
 */
public class SigninForThirdService implements ISigninForThirdService {

  private ISigninService signin;

  public SigninForThirdService(ISigninService iSignin) {
    this.signin = signin;
  }

  @Override
  public ResultMsg loginForQQ(String id) {
    return null;
  }

  @Override
  public ResultMsg loginForWechat(String id) {
    return null;
  }

  @Override
  public ResultMsg loginForToken(String token) {
    return null;
  }

  @Override
  public ResultMsg loginForTelphone(String telphone, String code) {
    return null;
  }

  @Override
  public ResultMsg loginForRegist(String username, String passport) {
    return null;
  }

  @Override
  public ResultMsg regist(String username, String password) {
    return null;
  }

  @Override
  public ResultMsg login(String username, String password) {
    return null;
  }
}
