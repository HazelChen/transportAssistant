package edu.nju.transportAssistant.webService;

public class TrainSearcher {
	private static final String TRAIN_WEB_SERVICE_URL = "http://webservice.webxml.com.cn/WebServices/TrainTimeWebService.asmx";
	
	private static final String BY_STATION_NAME_OPERATION = "getStationAndTimeByStationName";
	
	public void search(String from, String to) {
		String url = TRAIN_WEB_SERVICE_URL + "//" + BY_STATION_NAME_OPERATION;
		WebServiceInvoker invoker = new WebServiceInvoker(url);
		
		WebServiceParameter p1 = new WebServiceParameter("StartStation", from);
		invoker.add(p1);
		WebServiceParameter p2 = new WebServiceParameter("ArriveStation", to);
		invoker.add(p2);
		WebServiceParameter p3 = new WebServiceParameter("UserID", "");
		invoker.add(p3);
		
		String responseXml = invoker.invoke();
		System.out.println(responseXml);
	}
}
