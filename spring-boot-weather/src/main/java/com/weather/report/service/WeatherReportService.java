package com.weather.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.report.model.WeatherReport;
import com.weather.report.repository.WeatherRepositoryImpl;

@Service
public class WeatherReportService {

	@Autowired
	private WeatherRepositoryImpl weatherDAO;
	
	public WeatherReport save (WeatherReport report) {
		weatherDAO.saveWeather(report);
		return report;
	}
	
	public WeatherReport get (int id) {
		return weatherDAO.getWeather(id);
	}

	public List<WeatherReport> getAll(String date, String city, String sort) {
		List<WeatherReport> result = weatherDAO.queryWeather(date, city, sort);
		return result;
	}
	
}
