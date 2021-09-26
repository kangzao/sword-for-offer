package com.jep.github.designpattern.proxy.dbroute;

import com.jep.github.designpattern.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.jep.github.designpattern.proxy.dbroute.proxy.OrderServiceStaticProxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbRouteProxyTest {

  public static void main(String[] args) {
    try {
      Order order = new Order();

//            order.setCreateTime(new Date().getTime());

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date date = sdf.parse("2017/02/01");
      order.setCreateTime(date.getTime());
      //静态代理
//      IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
      //动态代理
      IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy()
          .getInstance(new OrderService());
      orderService.createOrder(order);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}