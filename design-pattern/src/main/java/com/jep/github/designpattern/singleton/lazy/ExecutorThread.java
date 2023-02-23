package com.jep.github.designpattern.singleton.lazy;

/*
 * @author: enping.jep
 * @create: 2021-09-16 4:27 下午
 */
public class ExecutorThread implements Runnable {

  @Override
  public void run() {
    LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
    System.out.println(Thread.currentThread().getName() + " : " + singleton);
  }
}
