package com.jep.github.designpattern.singleton.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeSingletonTest {

  public static void main(String[] args) {
    SerializeSingleton s1 = null;
    SerializeSingleton s2 = SerializeSingleton.getInstance();
    FileOutputStream fos = null;
    try {
      /**
       * ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream。
       * 可以使用 ObjectInputStream 读取（重构）对象。通过在流中使用文件可以实现对象的持久存储。
       * 如果流是网络套接字流，则可以在另一台主机上或另一个进程中重构对象。
       */
      fos = new FileOutputStream("SeriableSingleton.obj");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      //向输出流中写入对象
      oos.writeObject(s2);
      oos.flush();
      oos.close();

      FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
      ObjectInputStream ois = new ObjectInputStream(fis);
      s1 = (SerializeSingleton) ois.readObject();
      ois.close();
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s1 == s2);
//      运行结果中，可以看出，反序列化后的对象和手动创建的对象是不一致的，实例化了两次，违背了单例的设计初衷。
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}