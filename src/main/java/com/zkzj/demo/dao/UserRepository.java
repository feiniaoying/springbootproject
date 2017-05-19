package com.zkzj.demo.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zkzj.demo.entity.User;

/**
 * Created by chenwt on 2017/5/12.
 */
@Repository
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long>{

	/**
     * 通过年龄查询
     * @param age
     * @return
     */
    @Cacheable
    public List<User> findByAge(int age);
}
