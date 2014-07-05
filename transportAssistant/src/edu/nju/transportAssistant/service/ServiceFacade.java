package edu.nju.transportAssistant.service;

import java.util.ArrayList;
import java.util.List;

import edu.nju.transportAssistant.model.Flights;
import edu.nju.transportAssistant.model.TrainInfomation;
import edu.nju.transportAssistant.model.Transport;

public class ServiceFacade {
	private FlightsService flightsService;
	private TrainService trainService;
	private MailService mailService;
	private IPService ipService;

	public ServiceFacade() {
		flightsService = new FlightsService();
		trainService = new TrainService();
		mailService = new MailService();
		ipService = new IPService();
	}

	public ArrayList<Transport> search(String from, String to, String date) {
		List<TrainInfomation> trains = trainService.search(from, to);
		List<Flights> flightses = flightsService.search(from, to, date);

		ArrayList<Transport> transports = new ArrayList<Transport>();
		for (TrainInfomation trainInfomation : trains) {
			transports.add(trainInfomation.getTransport());
		}
		for (Flights flights : flightses) {
			transports.add(flights.getTransport());
		}
		return transports;
	}

	public ArrayList<Transport> search(String from, String to, String date,
			String startTime, String endTime) {
		ArrayList<Transport> transports = search(from, to, date);

		ArrayList<Transport> result = new ArrayList<Transport>();
		for (Transport transport : transports) {
			if (isTimeIn(startTime, endTime, transport.getStartTime())) {
				result.add(transport);
			}
		}
		return result;
	}
	
	public boolean validateEmail(String email) {
		return mailService.validate(email);
	}
	
	public String getIpPlace(String ip) {
		return ipService.analyse(ip);
	}

	private boolean isTimeIn(String startTime, String endTime, String realTime) {
		String[] fromsplit = startTime.split(":");
		String[] tosplit = endTime.split(":");
		String[] realTimesplit = realTime.split(":");
		int fromhour = Integer.parseInt(fromsplit[0]);
		int fromminute = Integer.parseInt(fromsplit[1]);
		int tohour = Integer.parseInt(tosplit[0]);
		int tominute = Integer.parseInt(tosplit[1]);
		int realhour = Integer.parseInt(realTimesplit[0]);
		int realminute = Integer.parseInt(realTimesplit[1]);
		int fromtotal = fromhour * 60 + fromminute;
		int tototal = tohour * 60 + tominute;
		int realtotal = realhour * 60 + realminute;
		if ((realtotal > fromtotal) && (realtotal < tototal)) {
			return true;
		} else
			return false;
	}

}
