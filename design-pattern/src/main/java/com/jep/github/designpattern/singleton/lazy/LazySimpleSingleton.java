package com.jep.github.designpattern.singleton.lazy;

//懒汉式单例
//在外部需要使用的时候才进行实例化
public class LazySimpleSingleton {

  private LazySimpleSingleton() {
  }

  //静态块，公共内存区域
  private static LazySimpleSingleton lazy = null;

  //变成线程同步方法,防止出现不同的单例
  public synchronized static LazySimpleSingleton getInstance() {
    if (lazy == null) {
      lazy = new LazySimpleSingleton();
    }
    return lazy;
  }
}