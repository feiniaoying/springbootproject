package com.zkzj.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zkzj.demo.util.BaseUtil;

public class MailServiceTest extends BaseUtil {

	@Autowired
	private MailService mailService;
	
	private String to = "feiniaoying@163.com";
	
	@Test
	public void sendSimpleMail() {
		mailService.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");
	}

//	@Autowired
//	Configuration configuration; //freeMarker configuration
//	
//	@Test
//	public void sendHtmlMailUsingFreeMarker() throws Exception {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("time", new Date());
//		model.put("message", "这是测试的内容。。。");
//		model.put("toUserName", "张三");
//		model.put("fromUserName", "老许");
//		
//		Template t = configuration.getTemplate("welcome.ftl"); // freeMarker template
//		String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
//
//		logger.debug(content);
//		//mailService.sendHtmlMail(to, "主题：html邮件", content);
//	}
//	 
	
/*	@Autowired
	VelocityEngine velocityEngine;
	
	@Test
	public void sendHtmlMail() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("time", XDateUtils.nowToString());
		model.put("message", "这是测试的内容。。。");
		model.put("toUserName", "张三");
		model.put("fromUserName", "老许");
		String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "welcome.vm", "UTF-8", model);
		
		mailService.sendHtmlMail(to, "主题：html邮件", content);
	}*/

	@Test
	public void sendAttachmentsMail() {
		mailService.sendAttachmentsMail(to, "主题：急件", "这是一封信件！", "C:/Users/chenwt/Desktop/logos.png");
	}
	
	@Test
	public void sendInlineResourceMail() {
		String rscId = "rscId001";
		mailService.sendInlineResourceMail(to,
				"主题：嵌入静态资源的邮件",
				"<html><body>这是有嵌入静态资源：<img src=\'cid:" + rscId + "\' ></body></html>",
				"C:\\Users\\chenwt\\Desktop\\logos.png",
				rscId);
}

}
