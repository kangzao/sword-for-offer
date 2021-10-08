package com.jep.github.designpattern.spring.aop;

import com.jep.github.designpattern.spring.aop.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//运行该代码示例时，需要注释掉XmlAspectTest的SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationAspectTest {

  @Autowired
  MemberService memberService;

  @Test
  public void testGet() {
    memberService.get();
  }
}