package com.zkzj.demo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkzj.demo.annotation.Auditable;
import com.zkzj.demo.entity.User;
import com.zkzj.demo.service.UserService;

@RestController
@RequestMapping("/")
public class HelloController {
    private transient Log log = LogFactory.getLog(this.getClass());
    @Autowired
    private UserService userService;
    
    @Autowired
    private CacheManager cacheManager;
    
	
	@RequestMapping("/hello")
	@Auditable
	public User sayHello() {
		// TODO Auto-generated method stub
		 	log.error("----------------------第一次查询---------------------------------");
		    List<User> user1 = userService.getUserInfoByAge(22);
		    log.error("user ===== "+user1);
		    log.error("----------------------第二次查询---------------------------------");
		    List<User> user2 = userService.getUserInfoByAge(22);
		    log.error("user ===== "+user2);

		
		User user = userService.getUserInfo(1L);
        log.error("user ==="+user);

		return user;
	}
}
