package com.jep.github.designpattern.observer.gper;

public class ObserverTest {

  public static void main(String[] args) {
    GPer gper = GPer.getInstance();
    Teacher tom = new Teacher("Tom");
    Teacher mic = new Teacher("Mic");

    //这为没有@Tom老师
    Question question = new Question();
    question.setUserName("小明");
    question.setContent("观察者设计模式适用于哪些场景？");
    gper.addObserver(tom);
    gper.addObserver(mic);
    gper.publishQuestion(question);


  }

}