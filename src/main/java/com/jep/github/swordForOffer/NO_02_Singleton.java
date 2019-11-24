package com.jep.github.swordForOffer;

/**
 * Creared by jiangenping on 2019-11-24 12:13:11
 */

public class NO_02_Singleton {

    public static NO_02_Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    private NO_02_Singleton() {

    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全【推荐】
     */
    private static class SingletonHolder {
        private static final NO_02_Singleton singleton = new NO_02_Singleton();
    }

    public static void main(String[] args){
        System.out.println(NO_02_Singleton.getInstance() == NO_02_Singleton.getInstance());
    }


}
