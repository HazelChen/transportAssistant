package edu.nju.transportAssistant.webService;

public class IPWebService {
private static final String FLIGHTS_WEB_SERVICE_URL = "http://webservice.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx";
	
	private static final String BY_IP_DETAIL_OPERATION = "getCountryCityByIp";
	
	public String findIpInfo(String ip) {
		String url = FLIGHTS_WEB_SERVICE_URL + "/" + BY_IP_DETAIL_OPERATION;
		WebServiceInvoker invoker = new WebServiceInvoker(url);
		
		WebServiceParameter p1 = new WebServiceParameter("theIpAddress", ip);
		invoker.add(p1);
		
		String responseXml = invoker.invoke();
		return responseXml;
	}
}
