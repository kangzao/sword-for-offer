package com.jep.github.designpattern.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * XML版Aspect切面Bean
 */
@Slf4j
public class XmlAspect {


  /*
   * 配置前置通知,使用在方法aspect()上注册的切入点
   * 同时接受JoinPoint切入点对象,可以没有该参数
   */
  public void before(JoinPoint joinPoint) {
    log.info("" + joinPoint.getArgs()); //获取实参列表
    log.info("" + joinPoint.getKind());  //连接点类型，如method-execution
    log.info("" + joinPoint.getSignature()); //获取被调用的切点
    log.info("" + joinPoint.getTarget());  //获取目标对象
    log.info("" + joinPoint.getThis());  //获取this的值

    log.info("before通知 " + joinPoint);
  }

  //配置后置通知,使用在方法aspect()上注册的切入点
  public void after(JoinPoint joinPoint) {
    log.info("after通知 " + joinPoint);
  }

  //配置环绕通知,使用在方法aspect()上注册的切入点
  public void around(JoinPoint joinPoint) {
    long start = System.currentTimeMillis();
    try {
      ((ProceedingJoinPoint) joinPoint).proceed();
      long end = System.currentTimeMillis();
      log.info("around通知 " + joinPoint + "\tUse time : " + (end - start) + " ms!");
    } catch (Throwable e) {
      long end = System.currentTimeMillis();
      log.info(
          "around通知 " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e
              .getMessage());
    }
  }

  //配置后置返回通知,使用在方法aspect()上注册的切入点
  public void afterReturn(JoinPoint joinPoint) {
    log.info("afterReturn通知 " + joinPoint);
  }

  //配置抛出异常后通知,使用在方法aspect()上注册的切入点
  public void afterThrow(JoinPoint joinPoint, Exception ex) {
    log.info("afterThrow通知 " + joinPoint + "\t" + ex.getMessage());
  }

}