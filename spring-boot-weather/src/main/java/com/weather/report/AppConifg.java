package com.weather.report;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConifg {

	@Bean
	public MongoClient mongoClient() {
		String connectionString = "mongodb://weather-reporter:9m8dC7fhkTiHaeB@cluster0-shard-00-00.csacl.mongodb.net:27017,"
				+ "cluster0-shard-00-01.csacl.mongodb.net:27017,"
				+ "cluster0-shard-00-02.csacl.mongodb.net:27017"
				+ "/weather-db?ssl=true&replicaSet=atlas-55i64x-shard-0&authSource=admin&retryWrites=true&w=majority";
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		return MongoClients.create(MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(connectionString)).codecRegistry(codecRegistry).build());
	}
	
}
