package com.jep.github.designpattern.proxy.dbroute.proxy;

import com.jep.github.designpattern.proxy.dbroute.db.DynamicDataSourceEntity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author: enping.jep
 * @create: 2021-09-24 2:35 下午
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

  private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
  private Object target;

  public Object getInstance(Object target) {
    this.target = target;
    Class<?> clazz = target.getClass();
    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
  }


  private void before(Object target) {
    try {
      System.out.println("Proxy before method.");
      Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
      Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
      System.out.println("动态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据。");
      DynamicDataSourceEntity.set(dbRouter);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before(args[0]);
    Object object = method.invoke(target, args);
    after();
    return object;
  }

  private void after() {
    System.out.println("Proxy after method.");
  }
}
