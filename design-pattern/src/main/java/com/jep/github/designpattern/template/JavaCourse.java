package com.jep.github.designpattern.template;

public class JavaCourse extends NetworkCourse {

  void checkHomework() {
    System.out.println("检查Java的架构课件");
  }


  protected boolean needHomework() {
    return true;
  }
}