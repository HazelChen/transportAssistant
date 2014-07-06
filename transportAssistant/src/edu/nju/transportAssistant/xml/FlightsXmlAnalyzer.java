package edu.nju.transportAssistant.xml;

import java.util.ArrayList;

import edu.nju.transportAssistant.model.Flights;

public class FlightsXmlAnalyzer {
	private static final int PROPERTY_COUNT = 9;
	
	public ArrayList<Flights> analyse(String xml) {
		ArrayList<Flights> flightses = new ArrayList<Flights>();
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		while (analyzer.hasNext()) {
			ArrayList<String> proprties = analyzer.next();
			if (proprties.size() != PROPERTY_COUNT) {
				break;
			}
			
			String company = proprties.get(0);
			
			if (company.equals("没有航班") || company.equals("出发或抵达的城市不被支持")) {
				break;
			}
			
			Flights flights = new Flights(company, proprties.get(1),
					proprties.get(2), proprties.get(3), proprties.get(4), 
					proprties.get(5), proprties.get(6), proprties.get(7), 
					proprties.get(8)); 
			flightses.add(flights);
		}
		return flightses;
	}
}
