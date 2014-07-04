package edu.nju.transportAssistant.webService;

public class FlightsSearcher {
	private static final String FLIGHTS_WEB_SERVICE_URL = "http://webservice.webxml.com.cn/webservices/DomesticAirline.asmx";
	
	private static final String BY_STATION_NAME_OPERATION = "getDomesticAirlinesTime";
	
	public String search(String from, String to, String dateString) {
		String url = FLIGHTS_WEB_SERVICE_URL + "//" + BY_STATION_NAME_OPERATION;
		WebServiceInvoker invoker = new WebServiceInvoker(url);
		
		WebServiceParameter p1 = new WebServiceParameter("startCity", from);
		invoker.add(p1);
		WebServiceParameter p2 = new WebServiceParameter("lastCity", to);
		invoker.add(p2);
		WebServiceParameter p3 = new WebServiceParameter("theDate", dateString);
		invoker.add(p3);
		WebServiceParameter p4 = new WebServiceParameter("userID", "");
		invoker.add(p4);
		
		String responseXml = invoker.invoke();
		return responseXml;
	}
}
