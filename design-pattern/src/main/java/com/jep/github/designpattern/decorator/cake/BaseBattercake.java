package com.jep.github.designpattern.decorator.cake;

public class BaseBattercake extends Battercake {

  protected String getMsg() {
    return "煎饼";
  }

  public int getPrice() {
    return 5;
  }
}