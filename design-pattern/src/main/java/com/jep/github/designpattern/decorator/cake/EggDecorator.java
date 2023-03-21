package com.jep.github.designpattern.decorator.cake;

import com.jep.github.designpattern.decorator.cake.Battercake;
import com.jep.github.designpattern.decorator.cake.BattercakeDecorator;

public class EggDecorator extends BattercakeDecorator {

  public EggDecorator(Battercake battercake) {
    super(battercake);
  }

  protected void doSomething() {

  }

  @Override
  protected String getMsg() {
    return super.getMsg() + "+1个鸡蛋";
  }

  @Override
  protected int getPrice() {
    return super.getPrice() + 1;
  }
}