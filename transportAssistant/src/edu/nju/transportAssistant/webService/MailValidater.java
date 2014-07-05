package edu.nju.transportAssistant.webService;

public class MailValidater {
	private static final String MAIL_WEB_SERVICE_URL = "http://webservice.webxml.com.cn/WebServices/ValidateEmailWebService.asmx/ValidateEmailAddress";
	
	public String validate(String email) {
		WebServiceInvoker invoker = new WebServiceInvoker(MAIL_WEB_SERVICE_URL);
		
		WebServiceParameter p = new WebServiceParameter("theEmail", email);
		invoker.add(p);
		
		String responseXml = invoker.invoke();
		return responseXml;
	}
}
