package com.jep.github.designpattern;

/*
 * @author: enping.jep
 * @create: 2020-09-25 10:15 AM
 * 懒汉式单例
 * 在外部需要使用的时候才进行实例化
 */
public class LazySimpleSingleton {

  private LazySimpleSingleton() {
  }

  private volatile static LazySimpleSingleton lazy = null;

  public synchronized static LazySimpleSingleton getInstance() {
    if (lazy == null) {
      synchronized (LazySimpleSingleton.class) {
        if (lazy == null) {
          lazy = new LazySimpleSingleton();
        }
      }

    }
    return lazy;
  }
}
