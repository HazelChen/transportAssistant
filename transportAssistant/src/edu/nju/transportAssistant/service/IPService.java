package edu.nju.transportAssistant.service;

import edu.nju.transportAssistant.webService.IPWebService;
import edu.nju.transportAssistant.xml.IPInfoAnalyzer;

public class IPService {
	private IPWebService webService;
	private IPInfoAnalyzer analyzer;
	
	public IPService() {
		webService = new IPWebService();
		analyzer = new IPInfoAnalyzer();
	}
	
	public String analyse(String ip) {
		String xml = webService.findIpInfo(ip);
		String place = analyzer.analyse(xml);
		return place;
	}
}
