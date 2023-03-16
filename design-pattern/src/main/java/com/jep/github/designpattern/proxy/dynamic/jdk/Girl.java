package com.jep.github.designpattern.proxy.dynamic.jdk;

import com.jep.github.designpattern.proxy.staticproxy.Person;

public class Girl implements Person {
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}