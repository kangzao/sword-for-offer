package com.jep.github.designpattern;

/*
 * @author: enping.jep
 * @create: 2020-09-25 3:25 PM
 * 注册时单例
 */
public enum EnumSingleton {

  INSTANCE;
  private Object data;

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public static EnumSingleton getInstance() {
    return INSTANCE;
  }
}
