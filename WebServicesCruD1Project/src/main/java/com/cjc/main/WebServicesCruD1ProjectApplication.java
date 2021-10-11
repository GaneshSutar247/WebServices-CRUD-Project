package com.cjc.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class WebServicesCruD1ProjectApplication {

	private static final Logger logger = LoggerFactory.getLogger(WebServicesCruD1ProjectApplication.class);

	public static void main(String[] args) {
		
		logger.info("Web-Services CruD Starts Here");
		
		SpringApplication.run(WebServicesCruD1ProjectApplication.class, args);
	}

}
