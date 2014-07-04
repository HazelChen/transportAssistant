package edu.nju.transportAssistant.model;

public class Flights {
	private String company;
	private String airlineCode;
	private String startDrome;
	private String arriveDrome;
	private String startTime;
	private String arriveTime;
	private String mode;
	private String airlineStop;
	private String week;
	
	public Flights(){}
	
	public Flights(String company, String airlineCode, String startDrome,
			String arriveDrome, String startTime, String arriveTime,
			String mode, String airlineStop, String week) {
		this.company = company;
		this.airlineCode = airlineCode;
		this.startDrome = startDrome;
		this.arriveDrome = arriveDrome;
		this.startTime = startDrome;
		this.arriveTime = arriveTime;
		this.startTime = startTime;
		this.arriveTime = arriveTime;
		this.mode = mode;
		this.airlineStop = airlineStop;
		this.week = week;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getStartDrome() {
		return startDrome;
	}

	public void setStartDrome(String startDrome) {
		this.startDrome = startDrome;
	}

	public String getArriveDrome() {
		return arriveDrome;
	}

	public void setArriveDrome(String arriveDrome) {
		this.arriveDrome = arriveDrome;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getAirlineStop() {
		return airlineStop;
	}

	public void setAirlineStop(String airlineStop) {
		this.airlineStop = airlineStop;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

}
