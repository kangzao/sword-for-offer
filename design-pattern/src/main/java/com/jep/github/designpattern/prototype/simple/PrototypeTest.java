package com.jep.github.designpattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {

  public static void main(String[] args) {
// 创建一个具体的需要克隆的对象
    ConcretePrototypeA concretePrototype = new ConcretePrototypeA(); // 填充属性，方便测试
    concretePrototype.setAge(18);
    concretePrototype.setName("prototype");
    List hobbies = new ArrayList<String>();
    concretePrototype.setHobbies(hobbies);
    System.out.println(concretePrototype);

    Client client = new Client(concretePrototype);// 创建 Client 对象，准备开始克隆
    ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA)
        client.startClone(concretePrototype);
    System.out.println(concretePrototypeClone);
    System.out.println("克隆对象中的引用类型地址值:" + concretePrototypeClone.getHobbies());
    System.out.println("原对象中的引用类型地址值:" + concretePrototype.getHobbies());
    System.out.println("对象地址比较:" + (concretePrototypeClone.getHobbies() ==
        concretePrototype.getHobbies()));
  }
}