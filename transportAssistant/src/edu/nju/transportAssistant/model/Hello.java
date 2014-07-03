package edu.nju.transportAssistant.model;

import javax.faces.bean.ManagedBean;

import edu.nju.transportAssistant.webService.TrainSearcher;

@ManagedBean
public class Hello {
	final String world = "Hello World!";
	
	public String getworld() {
		TrainSearcher trainSearcher = new TrainSearcher();
		trainSearcher.search("福州", "南京");
		return world;
	}
}
