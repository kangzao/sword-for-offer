package com.jep.github.designpattern.strategy.promotion;

public class PromotionActivityTest {

  public static void main(String[] args) {
    String promotionKey = "GROUPBUY";
    PromotionActivity promotionActivity = new
        PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
    promotionActivity.execute();
  }


}