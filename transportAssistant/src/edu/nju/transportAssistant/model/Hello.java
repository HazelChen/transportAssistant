package edu.nju.transportAssistant.model;

import javax.faces.bean.ManagedBean;

import edu.nju.transportAssistant.qunarService.TrainPriceFetcher;
import edu.nju.transportAssistant.service.TrainService;

@ManagedBean
public class Hello {
	final String world = "Hello World!";
	
	public String getworld() {
		TrainPriceFetcher fetcher = new TrainPriceFetcher();
		fetcher.getPrice("D2282");
//		TrainService trainService = new TrainService();
//		trainService.search("福州", "南京");
		return world;
	}
}
