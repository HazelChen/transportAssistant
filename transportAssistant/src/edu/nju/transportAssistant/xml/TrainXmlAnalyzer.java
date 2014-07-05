package edu.nju.transportAssistant.xml;

import java.util.ArrayList;

import edu.nju.transportAssistant.model.TrainInfomation;

public class TrainXmlAnalyzer {
	private static final int PROPERTY_COUNT = 9;
	
	public ArrayList<TrainInfomation> analyse(String xml) {
		ArrayList<TrainInfomation> trains = new ArrayList<TrainInfomation>();
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		while (analyzer.hasNext()) {
			ArrayList<String> proprties = analyzer.next();
			if (proprties.size() != PROPERTY_COUNT) {
				break;
			}
			
			TrainInfomation train = new TrainInfomation(proprties.get(0), 
					proprties.get(1), proprties.get(2), proprties.get(3), 
					proprties.get(4).substring(0, 5), proprties.get(5), 
					proprties.get(6).substring(0, 5), proprties.get(7), 
					proprties.get(8));
			trains.add(train);
		}
		return trains;
	}
}
