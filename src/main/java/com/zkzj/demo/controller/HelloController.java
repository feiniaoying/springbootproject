package com.zkzj.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		// TODO Auto-generated method stub
		return "hellozkzjspringboot!";
	}
}
