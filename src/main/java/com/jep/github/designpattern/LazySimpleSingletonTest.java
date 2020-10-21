package com.jep.github.designpattern;

/*
 * @author: enping.jep
 * @create: 2020-09-25 10:25 AM
 */
public class LazySimpleSingletonTest {

  public static void main(String args[]) {

    Thread t1 = new Thread(new ExecutorThread());
    Thread t2 = new Thread(new ExecutorThread());

    t1.start();
    t2.start();
    System.out.println("end");
//    Thread-0:com.jep.github.designpattern.LazySimpleSingleton@7c22ad4a
//    Thread-1:com.jep.github.designpattern.LazySimpleSingleton@28a8fc97
//    说明单例存在线程安全隐患m

  }

}
