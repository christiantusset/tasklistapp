package com.christiantusset.tasklistapp.config;

import com.christiantusset.tasklistapp.persist.DemoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DemoDB demoDb;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		demoDb.instantiateTestDatabase();
		return true;
	}
}
