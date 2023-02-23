package com.jep.github.designpattern.simplefactory;

public class SimpleFactoryTest {

  public static void main(String[] args) {

    CourseFactory factory = new CourseFactory();
    ICourse course = factory.create(JavaCourse.class);
    course.record();

  }
}