package com.jep.github.designpattern.proxy.dynamic.gp;

import com.jep.github.designpattern.proxy.dynamic.jdk.Girl;
import com.jep.github.designpattern.proxy.staticproxy.Person;

public class GPProxyTest {

  public static void main(String[] args) {
    try {

      //JDK动态代理的实现原理
      Person obj = (Person) new GPMeipo().getInstance(new Girl());
      System.out.println(obj.getClass());
      obj.findLove();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}