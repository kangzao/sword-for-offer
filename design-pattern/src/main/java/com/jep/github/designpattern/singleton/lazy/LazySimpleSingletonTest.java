package com.jep.github.designpattern.singleton.lazy;

/*
 * @author: enping.jep
 * @create: 2021-09-17 2:09 下午
 */
public class LazySimpleSingletonTest {

  public static void main(String args[]) {
    Thread t1 = new Thread(new ExecutorThread());
    Thread t2 = new Thread(new ExecutorThread());
    t1.start();
    t2.start();
    System.out.println("end");
  }

}
