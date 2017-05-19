package com.zkzj.demo.service;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zkzj.demo.dao.UserRepository;
import com.zkzj.demo.entity.User;


/**
 * Created by chenwt on 2017/5/12.
 */
@Service
public class UserService {
    private transient Log log = LogFactory.getLog(this.getClass());

    @Resource
    private UserRepository userDao;

    public User getUserInfo(Long id) {
//        User user1 = userDao.findOne(id);
//        List<User> list = userDao.findByAge(22);
//        List<User> list1 = userDao.findAll();
//    	log.error("----------------------第一次查询---------------------------------");
// 	    User user1 = userDao.findOne(1L);	
// 	    log.error("----------------------第二次查询---------------------------------");
// 	    User user2 = userDao.findOne(1L);	
    	
        return userDao.findOne(id);
       // return null;
    }
 
    
    public List<User> getUserInfoByAge(int age) {
        return userDao.findByAge(age);
    	
    }
    public int updateUserInfo(User user) {
        return 0;
    }

    public void saveUser(User user) {
    }

    public void deleteUser(Long id) {
    }
}
