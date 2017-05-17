package com.zkzj.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zkzj.demo.entity.User;
import com.zkzj.demo.service.UserService;

@RestController
@RequestMapping("/")
public class HelloController {
    private transient Log log = LogFactory.getLog(this.getClass());
    @Autowired
    private UserService userService;
	
	@RequestMapping("/hello")
	public User sayHello() {
		// TODO Auto-generated method stub
		User user = userService.getUserInfo(1L);
        log.error("user ==="+userService.getUserInfo(1L));

		return user;
	}
}
