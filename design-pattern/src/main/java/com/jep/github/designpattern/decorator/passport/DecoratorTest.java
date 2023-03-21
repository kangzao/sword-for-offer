package com.jep.github.designpattern.decorator.passport;

public class DecoratorTest {

  public static void main(String[] args) {
    ISigninForThirdService signinForThirdService = new SigninForThirdService(new SigninService());
    signinForThirdService.loginForQQ("xdcdfswrwsdfssdfqsdf");
//为某个类实现动态增加或者覆盖原有方法的情况，采用装饰器模式 }
  }
}