package edu.nju.transportAssistant.model;

public class TrainInfomation {
	private String trainCode;
	private String firstStation;
	private String lastStation;
	private String startStation;
	private String startTime;
	private String arriveStation;
	private String arriveTime;
	private String mileage;
	private String takeTime;
	private double price;
	
	public TrainInfomation(){}
	
	public TrainInfomation(String trainCode, String firstStation, String lastStation,
			String startStation, String startTime, String arriveStation, String arriveTime, 
			String mileage, String takeTime) {
		
		this.trainCode = trainCode;
		this.firstStation = firstStation;
		this.lastStation = lastStation;
		this.startStation = startStation;
		this.startTime = startTime;
		this.arriveStation = arriveStation;
		this.arriveTime = arriveTime;
		this.mileage = mileage;
		this.takeTime = takeTime;
		this.price = ((int)(((Math.random() * 400) + 50) * 100)) / 100.0;
	}

	public String getTrainCode() {
		return trainCode;
	}

	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}

	public String getFirstStation() {
		return firstStation;
	}

	public void setFirstStation(String firstStation) {
		this.firstStation = firstStation;
	}

	public String getLastStation() {
		return lastStation;
	}

	public void setLastStation(String lastStation) {
		this.lastStation = lastStation;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
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

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getArriveStation() {
		return arriveStation;
	}

	public void setArriveStation(String arriveStation) {
		this.arriveStation = arriveStation;
	}
	
	@Override
	public String toString() {
		String info =  "车次号:" + trainCode + "\n" 
				+ "始发站:" + firstStation + "\n" 
				+ "到达站:" + lastStation + "\n" 
				+ "出发站:" + startStation + "\n"
				+ "出发时间:" + startTime + "\n"
				+ "到达站:" + arriveStation + "\n"
				+ "到达时间:" + arriveTime + "\n"
				+ "里程:" + mileage + "\n"
				+ "运行时间:" + takeTime + "\n"
				+ "价格:" + price + "\n";
		return info;
	}
}
