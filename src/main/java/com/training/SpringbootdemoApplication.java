package com.training;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}

@Component
class ApplicationStartupRunner implements CommandLineRunner {
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void run(String... args) throws Exception {
		logger.info("Hello world!");
	}
}
