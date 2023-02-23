package com.jep.github.designpattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器缓存
 */
public class ContainerSingleton {

  private ContainerSingleton() {
  }

  private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

  public static Object getInstance(String className) {
    if (!ioc.containsKey(className)) {
      Object instance = null;
      try {
        Class<?> clazz = Class.forName(className);
        synchronized (clazz) {
          if (!ioc.containsKey(className)) {
            System.out.println("初始化一次");
            instance = Class.forName(className).newInstance();
            ioc.put(className, instance);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      //return instance;
      return ioc.get(className);
    } else {
      return ioc.get(className);
    }
  }

}