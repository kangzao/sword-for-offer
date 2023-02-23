package com.jep.github.designpattern.singleton.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnumSingletonTest {

  public static void main(String[] args) {
    try {
      EnumSingleton instance1 = null;
      EnumSingleton instance2 = EnumSingleton.getInstance();
      instance2.setData(new Object());
      //将对象写入文件
      FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(instance2);
      oos.flush();
      oos.close();

      //从文件中还原对象
      FileInputStream fis = new FileInputStream("EnumSingleton.obj");
      ObjectInputStream ois = new ObjectInputStream(fis);
      instance1 = (EnumSingleton) ois.readObject();
      ois.close();
      System.out.println(instance1.getData());
      System.out.println(instance2.getData());
      //没有做任何处理，枚举式单例返回true
      System.out.println(instance1.getData() == instance2.getData());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}