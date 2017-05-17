package com.zkzj.demo.util;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.zkzj.demo.config.ConnectionSettings;

//说明类为IoC容器  
@Configuration
//指定自动扫描包  
@ComponentScan(basePackages = { "com.zkzj.demo.commandlinerunner","com.zkzj.demo.service","com.zkzj.demo.entity"})  
public class JavaConfig {
////////////////////////////////////////////////////////////////////////////////
	/** 数据库连接池druid的配置 */  
//	SpringBoot可以统一的配置application.yaml，但是目前仅仅支持dbcp、dbcp2、hikari
//	下面这种方式无法不支持的DruidDataSource的其他参数
//  这块采用的是ServletRegistrationBean 和FilterRegistrationBean的方式进行注册Servlet和Filter，这种是SpingBoot里面提供支持原生的方式
//	除了这种方式还可以采用其他方式进行配置，采用Servlet3.0的注解Servlet进行配置
//  这块配置基本就完事了，可以访问本地链接http://localhost:8080/druid/datasource.html查看监控信息
////////////////////////////////////////////////////////////////////////////////
	@Resource
    private ConnectionSettings connectionSettings;
	/**
     * 注册DruidServlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        return servletRegistrationBean;
    }

    /**
     * 注册DruidFilter拦截
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean duridFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<String, String>();
        //设置忽略请求
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.setInitParameters(initParams);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
    
    /**
     * 配置DataSource
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(connectionSettings.getDriverClassName());
        druidDataSource.setUsername(connectionSettings.getUserName());
        druidDataSource.setPassword(connectionSettings.getPassWord());
        druidDataSource.setUrl(connectionSettings.getUrl());
        druidDataSource.setMaxActive(100);
        druidDataSource.setFilters("stat,wall");
        druidDataSource.setInitialSize(10);
        return druidDataSource;
    }

}



