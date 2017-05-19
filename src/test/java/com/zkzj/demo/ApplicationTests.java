package com.zkzj.demo;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import com.zkzj.demo.entity.User;
import com.zkzj.demo.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableCaching----默认是开启，所以不必显示开启缓存
public class ApplicationTests {
    private transient Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private CacheManager cacheManager;
    
	@Autowired
    private UserService sv;
	
	
	 @Test
	 public void testCache() throws Exception {
	    log.error("----------------------第一次查询---------------------------------");
	    List<User> user1 = sv.getUserInfoByAge(22);
	    log.error("user ===== "+user1);
	    log.error("----------------------第二次查询---------------------------------");
	    List<User> user2 = sv.getUserInfoByAge(22);
	    log.error("user ===== "+user2);

	}



}
