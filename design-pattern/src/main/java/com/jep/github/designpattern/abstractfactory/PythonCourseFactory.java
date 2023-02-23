package com.jep.github.designpattern.abstractfactory;

public class PythonCourseFactory implements CourseFactory {

    public INote createNote() {
        return new PythonNote();
    }


    public IVideo createVideo() {
        return new PythonVideo();
    }
}