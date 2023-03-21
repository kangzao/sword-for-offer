package com.jep.github.designpattern.decorator.passport;

public interface ISigninForThirdService extends ISigninService {

  /**
   * QQ登录
   */
  ResultMsg loginForQQ(String id);

  /**
   * 微信登录
   */
  ResultMsg loginForWechat(String id);

  /**
   * 记住登录状态后自动登录
   */
  ResultMsg loginForToken(String token);

  /**
   * 手机号登录
   */
  ResultMsg loginForTelphone(String telphone, String code);


  ResultMsg loginForRegist(String username, String passport);
}