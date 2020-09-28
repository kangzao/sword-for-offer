package com.jep.github.designpattern;

import java.io.Serializable;

/*
 * @author: enping.jep
 * @create: 2020-09-25 3:03 PM
 * 反序列化时导致单例破坏
 */
public class SeriableSingleton implements Serializable {

  public final static SeriableSingleton INSTANCE = new SeriableSingleton();

  private SeriableSingleton() {
  }

  public static SeriableSingleton getInstance() {
    return INSTANCE;
  }

}
