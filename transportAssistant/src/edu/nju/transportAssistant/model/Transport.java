package edu.nju.transportAssistant.model;

public class Transport {
	private String type;
	private String code;
	private String startPlace;
	private String arrivePlace;
	private String startTime;
	private String arriveTime;
	private String duration;
	private double price;
	private double valueForMoney;

	public Transport() {
	}

	public Transport(String type, String code, String startPlace,
			String arrivePlace, String startTime, String arriveTime,
			String duration, double price) {
		this.type = type;
		this.code = code;
		this.startPlace = startPlace;
		this.arrivePlace = arrivePlace;
		this.startTime = startTime;
		this.arriveTime = arriveTime;
		this.duration = duration;
		this.price = price;
		this.valueForMoney = calValueOfMoney(duration, price);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getValueForMoney() {
		return valueForMoney;
	}

	public void setValueForMoney(double valueForMoney) {
		this.valueForMoney = valueForMoney;
	}

	private double calValueOfMoney(String duration, double price) {
		String[] s = duration.split(":");
		int time = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
		double d = time * price / 10000.0;
		double valueOfMoney = (int)(d * 100) / 100.0;
		return valueOfMoney;
	}
	
	@Override
	public String toString() {
		String info = "类型:" + type + "\n"
				+ "代码:" + code + "\n"
				+ "出发：" + startPlace + "\n"
				+ "出发时间:" + startTime + "\n"
				+ "到达时间:" + arriveTime + "\n"
				+ "时长:" + duration + "\n"
				+ "价格:" + price + "\n"
				+ "性价比" + valueForMoney + "\n";
		return info;
	}
}
