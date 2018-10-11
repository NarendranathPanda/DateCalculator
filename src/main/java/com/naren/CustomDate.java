package com.naren;

public class CustomDate {

	String dateString = null;

	public CustomDate(String dateString) {
		this.dateString = dateString;
	}

	public int getDay() {
		return Integer.parseInt(dateString.split("-")[0]);
	}

	public String getMonth() {
		return dateString.split("-")[1];
	}

	public int getYear() {
		return Integer.parseInt(dateString.split("-")[2]);
	}

}
