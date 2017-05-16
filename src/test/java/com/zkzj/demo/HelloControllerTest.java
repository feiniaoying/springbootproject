package com.zkzj.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.zkzj.demo.controller.HelloController;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages={"com.zkzj.demo.controller"})
public class HelloControllerTest {
	@Resource
	private HelloController HelloController;
	
	@Test
	public void testSayHello() {
		System.out.println(HelloController.sayHello());
	}

}
