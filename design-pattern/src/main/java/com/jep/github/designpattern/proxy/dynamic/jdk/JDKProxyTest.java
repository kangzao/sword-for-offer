package com.jep.github.designpattern.proxy.dynamic.jdk;

import com.jep.github.designpattern.proxy.staticproxy.Person;


public class JDKProxyTest {

  public static void main(String[] args) {
    try {
      Person obj = (Person) new JDKMeipo().getInstance(new Girl());
      obj.findLove();
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}