package com.weather.report.repository;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.weather.report.model.WeatherReport;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@Autowired
	private MongoClient client;
	private MongoCollection<WeatherReport> reportCollection;

	@PostConstruct
	void init() {
		reportCollection = client.getDatabase("weather-db").getCollection("data", WeatherReport.class);
	}

	public WeatherReport saveWeather(WeatherReport report) {
		report.setId((int) (Math.random() * 10000));
		reportCollection.insertOne(report);
		return report;
	}

	public List<WeatherReport> queryWeather(String date, String city, String sort) {
		FindIterable<WeatherReport> results;
		if (date != null && city != null) {
			results = reportCollection.find(and(eq("date", date), eq("city", city)));

		} else if (date != null) {
			results = reportCollection.find(eq("date", date));

		} else if (city != null) {
			results = reportCollection.find(eq("city", city));

		} else {
			results = reportCollection.find();
		}

		if (sort != null) {
			if (sort.equals("-date")) {
				results.sort(new Document("date", -1));
			} else {
				results.sort(new Document("date", 1));
			}
		}
		List<WeatherReport> response = new ArrayList<WeatherReport>();
		return results.into(response);
	}

	public WeatherReport getWeather(int id) {
		BasicDBObject query = new BasicDBObject("_id", id);
		FindIterable<WeatherReport> results = reportCollection.find(query);

		return results.first();
	}

}
