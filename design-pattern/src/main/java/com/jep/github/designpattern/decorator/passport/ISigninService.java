package com.jep.github.designpattern.decorator.passport;

/*
 * @author: enping.jep
 * @create: 2023-03-21 7:07 PM
 */
public interface ISigninService {

  ResultMsg regist(String username, String password);

  ResultMsg login(String username, String password);

}
