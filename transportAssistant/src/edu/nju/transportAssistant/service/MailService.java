package edu.nju.transportAssistant.service;

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
}
