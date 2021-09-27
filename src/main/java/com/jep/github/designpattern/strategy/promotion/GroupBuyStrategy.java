package com.jep.github.designpattern.strategy.promotion;

public class GroupBuyStrategy implements PromotionStrategy {

  public void doPromotion() {
    System.out.println("拼团，满20人成团，全团享受团购价");
  }
}