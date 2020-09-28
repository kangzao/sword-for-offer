package com.jep.github.designpattern;

/*
 * @author: enping.jep
 * @create: 2020-09-25 10:24 AM
 */
public class ExecutorThread implements Runnable {

  @Override
  public void run() {
    LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
//    LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
    System.out.println(Thread.currentThread().getName() + ":" + singleton);
  }
}
