package com.jep.github.designpattern;

/*
 * @author: enping.jep
 * @create: 2020-09-25 11:04 AM
 */
public class LazyInnerClassSingleton {

  private LazyInnerClassSingleton() {
    //防止使用反射，强行调用构造方法
    if (LazyHolder.LAZY != null) {
      throw new RuntimeException("不允许创建多个实例");
    }
  }

  public static final LazyInnerClassSingleton getInstance() {
    return LazyHolder.LAZY;
  }

  private static class LazyHolder {

    private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
  }
}
