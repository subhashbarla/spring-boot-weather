package com.weather.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.report.model.WeatherReport;
import com.weather.report.service.WeatherReportService;

@RestController
@RequestMapping("/weather")
public class WeatherReportController {
	@Autowired
	private WeatherReportService weatherService;

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<WeatherReport> recordReport(@RequestBody WeatherReport request) {
		weatherService.save(request);
		return new ResponseEntity<WeatherReport>(request, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<WeatherReport>> getAllReports(@RequestParam(required = false) String date,
			@RequestParam(required = false) String city, @RequestParam(required = false) String sort) {
		List<WeatherReport> reponse = weatherService.getAll(date,city,sort);
		return new ResponseEntity<List<WeatherReport>>(reponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<WeatherReport> getReport(@PathVariable("id") int id) {
		WeatherReport report = weatherService.get(id);
		if(report == null) {
			return new ResponseEntity<WeatherReport>(new WeatherReport(),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<WeatherReport>(report, HttpStatus.OK);

	}
}
