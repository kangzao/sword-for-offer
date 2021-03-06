package com.jep.github.designpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * @author: enping.jep
 * @create: 2020-09-25 12:18 PM
 * 反射破坏单例
 */
public class LazyInnerClassSingletonTest {

  public static void main(String args[]) {

    Class<?> clazz = LazyInnerClassSingleton.class;

    try {
      Constructor c = clazz.getDeclaredConstructor(null);
      c.setAccessible(true);
      Object o1 = c.newInstance();
      Object o2 = c.newInstance();
      System.out.println(o1 == o2);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }


  }

}
