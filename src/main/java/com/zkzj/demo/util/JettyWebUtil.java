package com.zkzj.demo.util;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyWebUtil {
	@Bean  
    public EmbeddedServletContainerFactory servletContainer() {  
        JettyEmbeddedServletContainerFactory factory =  
                new JettyEmbeddedServletContainerFactory();  
        return factory;  
    }  

}
