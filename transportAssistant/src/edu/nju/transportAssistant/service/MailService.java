package edu.nju.transportAssistant.service;

import java.util.Date;

import edu.nju.transportAssistant.mail.MailUtil;
import edu.nju.transportAssistant.webService.MailValidater;
import edu.nju.transportAssistant.xml.EmailXmlAnalyzer;

public class MailService {
	private MailValidater validater;
	private EmailXmlAnalyzer analyzer;
	
	public MailService() {
		validater = new MailValidater();
		analyzer = new EmailXmlAnalyzer();
	}
	
	public boolean validate(String email) {
		String xml = validater.validate(email);
		int code = analyzer.analyse(xml);
		if (code == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void sendEmail(String email, String content) {
		MailUtil.sendMail("smtp.qq.com","25",true,
				"361549286@qq.com","361549286HFLW",
				email,"您的出行计划",
	    		 content, true, true);
	}
}
