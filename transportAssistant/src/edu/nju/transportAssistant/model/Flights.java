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
	private double price;
	
	public Flights(){}
	
	public Flights(String company, String airlineCode, String startDrome,
			String arriveDrome, String startTime, String arriveTime,
			String mode, String airlineStop, String week) {
		this.company = company;
		this.airlineCode = airlineCode;
		this.startDrome = startDrome;
		this.arriveDrome = arriveDrome;
		this.startTime = startTime;
		this.arriveTime = arriveTime;
		this.mode = mode;
		this.airlineStop = airlineStop;
		this.week = week;
		this.price = ((int)(((Math.random() * 1000) + 100) * 100)) / 100.0;
	}
	
	public Transport getTransport() {
		String duration = calDuration(startTime, arriveTime);
		
		Transport transport = new Transport("飞机", airlineCode, 
				startDrome, arriveDrome, startTime, arriveTime, 
				duration, price);
		return transport;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		String info = "航空公司:" + company + "\n"
				+ "航班号:" + airlineCode + "\n"
				+ "出发:" + startDrome + "\n"
				+ "到达:" + arriveDrome + "\n"
				+ "出发时间" + startTime + "\n"
				+ "到达时间" + arriveTime + "\n"
				+ "模式:" + mode + "\n"
				+ "中间停:" + airlineStop + "\n"
				+ "星期:" + week + "\n"
				+ "价格:" + price + "\n";
		return info;
	}

	private String calDuration(String startTime, String arriveTime) {
		String[] asplit = startTime.split(":");
		String[] bsplit = arriveTime.split(":");
		int ahour = Integer.parseInt(asplit[0]);
		int aminute = Integer.parseInt(asplit[1]);
		int bhour = Integer.parseInt(bsplit[0]);
		int bminute = Integer.parseInt(bsplit[1]);
		int atotal = ahour*60+aminute;
		int btotal = bhour*60+bminute;
		int deep = btotal - atotal;
		if(deep<0){
			deep = -deep;
		}
		String s = deep/60+":"+deep%60;
		return s;

	}
}
