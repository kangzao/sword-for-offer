package com.jep.github.designpattern.decorator.cake;
import com.jep.github.designpattern.decorator.cake.Battercake;
import com.jep.github.designpattern.decorator.cake.BattercakeDecorator;

public class SausageDecorator extends BattercakeDecorator {

  public SausageDecorator(Battercake battercake) {
    super(battercake);
  }

  protected void doSomething() {

  }

  @Override
  protected String getMsg() {
    return super.getMsg() + "+1根香肠";
  }

  @Override
  protected int getPrice() {
    System.out.println("com.jep.github.designpattern.decorator.SausageDecorator.getPrice");
    return super.getPrice() + 2;
  }
}