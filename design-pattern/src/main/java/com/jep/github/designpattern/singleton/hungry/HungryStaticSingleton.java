package com.jep.github.designpattern.singleton.hungry;

//饿汉式静态块单例
public class HungryStaticSingleton {

  private static final HungryStaticSingleton hungrySingleton;

  static {
    hungrySingleton = new HungryStaticSingleton();
  }

  private HungryStaticSingleton() {
  }

  public static HungryStaticSingleton getInstance() {
    return hungrySingleton;
  }
}