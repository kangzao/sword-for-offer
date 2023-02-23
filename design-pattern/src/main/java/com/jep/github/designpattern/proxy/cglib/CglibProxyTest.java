package com.jep.github.designpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    // 设置目标类
    enhancer.setSuperclass(TargetClass.class);
    // 设置拦截器对象
    enhancer.setCallback(new MyInterceptor());
    // 创建子类 即代理
    TargetClass targetClassProxy = (TargetClass) enhancer.create();
    targetClassProxy.targetInfo();
  }
}