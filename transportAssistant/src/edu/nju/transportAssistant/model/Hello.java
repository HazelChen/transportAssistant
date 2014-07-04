package edu.nju.transportAssistant.model;

import javax.faces.bean.ManagedBean;

import edu.nju.transportAssistant.service.TrainService;
import edu.nju.transportAssistant.webService.FlightsSearcher;

@ManagedBean
public class Hello {
	final String world = "Hello World!";
	
	public String getworld() {
//		TrainService trainService = new TrainService();
//		trainService.search("福州", "南京");
		FlightsSearcher searcher = new FlightsSearcher();
		String string = searcher.search("南京", "福州", "2014-07-10");
		System.out.println(string);
		return world;
	}
}
