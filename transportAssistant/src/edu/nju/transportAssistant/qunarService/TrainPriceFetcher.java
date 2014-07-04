package edu.nju.transportAssistant.qunarService;

public class TrainPriceFetcher {
	private static final String URL = "http://train.qunar.com/list_num.htm?fromStation=";
	private QunarPoster qunarPoster;
	
	public TrainPriceFetcher() {
		qunarPoster = new QunarPoster();
	}
	
	public double getPrice(String trainCode) {
		String response = qunarPoster.post(URL + trainCode);
		System.out.println(response);
		return 0.0;
	}
}
