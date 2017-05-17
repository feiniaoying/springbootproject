package com.zkzj.demo.commandlinerunner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zkzj.demo.service.UserService;

/**
 * 服务启动执行---适用预加载数据
 * @author chenwt
 *
 */
@Component
@Order(value = 1)//@Order 注解的执行优先级是按value值从小到大顺序。
public class MyStartupRunner1 implements CommandLineRunner {
    private transient Log log = LogFactory.getLog(this.getClass());

	@Override
	public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111 <<<<<<<<<<<<<");
		log.trace("I am chenwt trace.log");
        log.debug("I am chenwtdebug log.");
        log.warn("I am chenwtwarn log.");
        log.error("I am chenwterror log.");
	}
}

