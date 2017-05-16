package com.zkzj.demo.util;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试公共类
 * @author chenwt
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseUtil {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
