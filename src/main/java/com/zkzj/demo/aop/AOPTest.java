package com.zkzj.demo.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPTest {
    	private Log log = LogFactory.getLog(this.getClass());
	 	
    	@Pointcut("@annotation(com.zkzj.demo.annotation.Auditable)")
	    public void annotationPointCut() {
	    }

	 	@Before("annotationPointCut()")
	 	@Order(1)
	 	public void before(JoinPoint joinPoint){
	 		log.info("Signature declaring type : " + joinPoint.getSignature().getDeclaringTypeName());
	 	    log.info("Signature name : " + joinPoint.getSignature().getName());
	 	    log.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
	 	    log.info("Target class : " + joinPoint.getTarget().getClass().getName());
		}
	 	
	 	@AfterReturning(pointcut = "annotationPointCut()", returning = "result")
	    @Order(2)
	    public void logAfter(JoinPoint joinPoint, Object result)
	    {
		    log.info("Exiting from Method :" + joinPoint.getSignature().getName());
		    log.info("Return value :" + result);
	    }

}
