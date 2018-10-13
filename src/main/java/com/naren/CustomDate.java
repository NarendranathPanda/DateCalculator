package com.naren;

public class CustomDate {

	String dateString = null;

	public CustomDate(String dateString) {
		this.dateString = dateString;
	}

	public int getDay() {
		return Integer.parseInt(dateString.split("-")[0]);
	}

	public int getMonth() {
		return Integer.parseInt(dateString.split("-")[1]);
	}

	public int getYear() {
		return Integer.parseInt(dateString.split("-")[2]);
	}

	public String getDateString() {
		return dateString;
	}

}
