package com.smartcontact;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SmartcontactApplication implements CommandLineRunner {

	public static final Logger logger = LoggerFactory.getLogger(SmartcontactApplication.class);
	
	public static void main(String[] args) {
		logger.info("it's a continuous integration job");
		SpringApplication.run(SmartcontactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("it's a 2nd logger job");

	}

}
