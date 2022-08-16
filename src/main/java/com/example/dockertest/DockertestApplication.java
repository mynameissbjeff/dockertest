package com.example.dockertest;

import com.example.dockertest.controller.DockertestCtrl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockertestApplication {

	private static final Logger logger = LogManager.getLogger(DockertestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DockertestApplication.class, args);
		logger.trace("We've just greeted the user!");
		logger.debug("We've just greeted the user!");
		logger.info("We've just greeted the user!");
		logger.warn("We've just greeted the user!");
		logger.error("We've just greeted the user!");
		logger.fatal("We've just greeted the user!");
	}

}
