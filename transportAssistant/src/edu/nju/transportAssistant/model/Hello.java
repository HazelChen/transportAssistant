package edu.nju.transportAssistant.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.nju.transportAssistant.mail.MailSenderInfo;
import edu.nju.transportAssistant.mail.SimpleMailSender;
import edu.nju.transportAssistant.service.FlightsService;
import edu.nju.transportAssistant.service.ServiceFacade;
import edu.nju.transportAssistant.service.TrainService;
import edu.nju.transportAssistant.webService.IPWebService;
import edu.nju.transportAssistant.webService.MailValidater;

@ManagedBean
public class Hello {
	final String world = "Hello World!";

	public String getWorld() {
		sendEmail();
		// ServiceFacade facade = new ServiceFacade();
		// List<Transport> transports = facade.search("啊哈哈", "苏州",
		// "2014-07-10");
		// for (Transport transport : transports) {
		// System.out.println(transport);
		// }

		// System.out.println(facade.validateEmail("Chsadjawdia@qq.com"));

		// System.out.println(facade.getIpPlace("219.219.113.223"));
		return world;
	}

	private void sendEmail() {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("stmp.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);

		// 邮箱用户名
		mailInfo.setUserName("Hazel");
		// 邮箱密码
		mailInfo.setPassword("chin01_Hp");
		// 发件人邮箱
		mailInfo.setFromAddress("442166178@qq.com");
		// 收件人邮箱
		mailInfo.setToAddress("442166178@qq.com");
		// 邮件标题
		mailInfo.setSubject("测试Java程序发送邮件");
		// 邮件内容
		StringBuffer buffer = new StringBuffer();
		buffer.append("JavaMail 1.4.5 jar包下载地址：http://www.oracle.com/technetwork/java/index-138643.html\n");
		buffer.append("JAF 1.1.1 jar包下载地址：http://www.oracle.com/technetwork/java/javase/downloads/index-135046.html");
		mailInfo.setContent(buffer.toString());

		// 发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		// 发送文体格式
		sms.sendTextMail(mailInfo);
		// 发送html格式
//		SimpleMailSender.sendHtmlMail(mailInfo);
		System.out.println("邮件发送完毕");
	}
}
