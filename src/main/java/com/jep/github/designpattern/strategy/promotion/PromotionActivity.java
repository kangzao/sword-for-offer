package com.jep.github.designpattern.strategy.promotion;

public class PromotionActivity {

  private PromotionStrategy promotionStrategy;

  public PromotionActivity(PromotionStrategy promotionStrategy) {
    this.promotionStrategy = promotionStrategy;
  }

  public void execute() {
    promotionStrategy.doPromotion();
  }

}