package com.weather.report.model;

import java.util.List;

public class WeatherReport {
	private int id;
	
	private String date;
	
	private double lat;
	
	private double lon;
	
	private String city;
	
	private String state;
	
	private List<Double> temperatures;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Double> getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(List<Double> temperatures) {
		this.temperatures = temperatures;
	}

}
