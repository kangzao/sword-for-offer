package com.jep.github.designpattern.singleton.lazy;

public class LazyDoubleCheckSingleton {

  private volatile static LazyDoubleCheckSingleton lazy = null;

  private LazyDoubleCheckSingleton() {
  }

  public static LazyDoubleCheckSingleton getInstance() {
    if (lazy == null) {
      synchronized (LazyDoubleCheckSingleton.class) {
        if (lazy == null) {
          lazy = new LazyDoubleCheckSingleton();
          //1.分配内存给这个对象
          //2.初始化对象
          //3.设置lazy指向刚分配的内存地址
          //4.初次访问对象
          //所以lazy必须是volatile的
        }
      }
    }
    return lazy;
  }
}