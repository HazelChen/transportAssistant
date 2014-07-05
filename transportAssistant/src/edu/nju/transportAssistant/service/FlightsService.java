package edu.nju.transportAssistant.service;

import java.util.ArrayList;

import edu.nju.transportAssistant.model.Flights;
import edu.nju.transportAssistant.webService.FlightsSearcher;
import edu.nju.transportAssistant.xml.FlightsXmlAnalyzer;

public class FlightsService {
	private FlightsSearcher searcher;
	private FlightsXmlAnalyzer analyzer;
	
	public FlightsService() {
		searcher = new FlightsSearcher();
		analyzer = new FlightsXmlAnalyzer();
	}
	
	public ArrayList<Flights> search(String from, String to, String date) {
		String xml = searcher.search(from, to, date);
		ArrayList<Flights> flightses = analyzer.analyse(xml);
		
		return flightses;
	}
}
