package com.zkzj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 
 * @author chenwt
 *
 */
@SpringBootApplication
public class SpringbootprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootprojectApplication.class, args);
	}
//	
//	 @Bean
//	 CommandLineRunner sampleCommandLineRunner() {
//	        log.trace(" I am chenwt trace.log");
//	        log.debug(" I am chenwtdebug log.");
//	        log.warn( " I am chenwtwarn log.");
//	        log.error(" I am chenwterror log.");
//
//	       // return (args) -> System.out.println(this.cityMapper.insertCity(city));
//	        return (args) -> System.out.println(this.userDao.findOne(1L));
//	    }
}
