package com.jep.github.designpattern.proxy.dbroute.proxy;

import com.jep.github.designpattern.proxy.dbroute.IOrderService;
import com.jep.github.designpattern.proxy.dbroute.Order;
import com.jep.github.designpattern.proxy.dbroute.db.DynamicDataSourceEntity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

  private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

  private IOrderService orderService;

  public OrderServiceStaticProxy(IOrderService orderService) {
    this.orderService = orderService;
  }

  public int createOrder(Order order) {
    Long time = order.getCreateTime();
    Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
    System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
    DynamicDataSourceEntity.set(dbRouter);

    this.orderService.createOrder(order);
    DynamicDataSourceEntity.restore();

    return 0;
  }
}