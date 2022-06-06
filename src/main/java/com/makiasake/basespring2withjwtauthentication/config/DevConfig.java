package com.makiasake.basespring2withjwtauthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.makiasake.basespring2withjwtauthentication.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddlStrategy;
	
	@Bean
	public boolean intantiateDatebase() {
		
		if ("create".equals(ddlStrategy)) {
			this.dbService.instantiateTestDatabase();
		}
		
		return false;
	}
}
