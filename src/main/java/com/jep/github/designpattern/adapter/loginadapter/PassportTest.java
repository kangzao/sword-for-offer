package com.jep.github.designpattern.adapter.loginadapter;

import com.jep.github.designpattern.adapter.loginadapter.adapters.IPassportForThird;

public class PassportTest {

  public static void main(String[] args) {

    IPassportForThird passportForThird = new PassportForThirdAdapter();

    passportForThird.loginForQQ("");


  }

}