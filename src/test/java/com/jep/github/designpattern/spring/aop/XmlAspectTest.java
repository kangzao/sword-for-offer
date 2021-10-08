package com.jep.github.designpattern.spring.aop;

import com.jep.github.designpattern.spring.aop.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootApplication
@ImportResource(locations = {"classpath*:application-aop.xml"})
public class XmlAspectTest {

  @Autowired
  MemberService memberService;

  @Test
  public void testGet() {
    memberService.get();
  }

}
