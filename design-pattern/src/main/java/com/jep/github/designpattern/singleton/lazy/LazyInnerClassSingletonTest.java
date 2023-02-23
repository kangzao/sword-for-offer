package com.jep.github.designpattern.singleton.lazy;


import java.lang.reflect.Constructor;

/*
 * @author: enping.jep
 * @create: 2023-02-23 2:36 PM
 * 尝试通过反射破坏单例
 */
public class LazyInnerClassSingletonTest {

  public static void main(String args[]) {
    Class<?> clazz = LazyInnerClassSingleton.class;
    Constructor c;
    try {
      //通过反射获取构造方法
      c = clazz.getDeclaredConstructor(null);
      //强制访问
      c.setAccessible(true);
      //调用两次构造方法
      Object o1 = c.newInstance();
      Object o2 = c.newInstance();
      System.out.println(o1 == o2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
