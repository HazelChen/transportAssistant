package edu.nju.transportAssistant.service;

import java.util.ArrayList;

import edu.nju.transportAssistant.model.TrainInfomation;
import edu.nju.transportAssistant.webService.TrainSearcher;
import edu.nju.transportAssistant.xml.TrainXmlAnalyzer;

public class TrainService {
	private TrainSearcher searcher;
	private TrainXmlAnalyzer analyzer;
	
	public TrainService() {
		searcher = new TrainSearcher();
		analyzer = new TrainXmlAnalyzer();
	}
	
	public ArrayList<TrainInfomation> search(String from, String to) {
		String xml = searcher.search(from, to);
		ArrayList<TrainInfomation> trains = analyzer.analyse(xml);
		
		return trains;
	}
}
