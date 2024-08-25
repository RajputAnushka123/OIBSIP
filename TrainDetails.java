package bean;

import java.sql.Date;

public class TrainDetails {
	private int trainNumber;
	private String trainName;
	private String classType;
	private Date journyDate;
	private String from;
	private String to;
	

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	

	public Date getJournyDate() {
		return journyDate;
	}

	public void setJournyDate(Date journyDate) {
		this.journyDate = journyDate;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "TrainDetails [trainName=" + trainName + ", classType=" + classType + ", journyDate=" + journyDate
				+ ", from=" + from + ", to=" + to + "]";
	}
	

}
