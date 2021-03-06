package com.makiasake.basespring2withjwtauthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.makiasake.basespring2withjwtauthentication.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired private DBService dbService;
	
	@Bean
	public boolean intantiateDatebase() {
		this.dbService.instantiateTestDatabase();
		return true;
	}
}
