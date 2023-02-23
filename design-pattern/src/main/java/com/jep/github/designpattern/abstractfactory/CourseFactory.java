package com.jep.github.designpattern.abstractfactory;

public interface CourseFactory {

    INote createNote();

    IVideo createVideo();

}