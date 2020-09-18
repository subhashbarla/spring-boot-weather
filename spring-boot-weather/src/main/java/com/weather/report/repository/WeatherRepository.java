package com.weather.report.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weather.report.model.WeatherReport;

@Repository
public interface WeatherRepository {
	public WeatherReport saveWeather(WeatherReport report);
	public List<WeatherReport> queryWeather(String date, String city, String sort);
	public WeatherReport getWeather(int id);

}
