package com.example.smartcontact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartcontact.SmartcontactApplication;

@SpringBootTest
class SmartcontactApplicationTests {
	public static final Logger logger = LoggerFactory.getLogger(SmartcontactApplication.class);

	@Test
	void contextLoads() {
		
		logger.info("it's a test job");
		//Assertions.assertEquals(true, true);

	}

}
