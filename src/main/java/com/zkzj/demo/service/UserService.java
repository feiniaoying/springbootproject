package com.zkzj.demo.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkzj.demo.dao.UserRepository;
import com.zkzj.demo.entity.User;


/**
 * Created by chenwt on 2017/5/12.
 */
@Service
public class UserService {
    @Resource
    private UserRepository userDao;

    public User getUserInfo(Long id) {
        User user1 = userDao.findOne(id);
        List<User> list = userDao.findByAge(22);
        List<User> list1 = userDao.findAll();
        return userDao.findOne(id);
       // return null;
    }

    public int updateUserInfo(User user) {
        return 0;
    }

    public void saveUser(User user) {
    }

    public void deleteUser(Long id) {
    }
}
