package com.jep.github.designpattern.abstractfactory;

public class AbstractFactoryTest {

  public static void main(String[] args) {

    JavaCourseFactory factory = new JavaCourseFactory();

    factory.createNote().edit();
    factory.createVideo().record();

  }

}