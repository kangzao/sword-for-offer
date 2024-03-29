package com.jep.github.designpattern.observer.gper;

import java.util.Observable;

public class GPer extends Observable {

  private String name = "GPer生态圈";
  private static GPer gper = null;

  private GPer() {
  }

  public static GPer getInstance() {
    if (null == gper) {
      gper = new GPer();
    }
    return gper;
  }

  public String getName() {
    return name;
  }

  public void publishQuestion(Question question) {
    System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
    setChanged();
    notifyObservers(question);
  }
}