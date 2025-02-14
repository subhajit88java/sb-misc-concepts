package com.subhajit.sbmiscconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SbMiscConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMiscConceptsApplication.class, args);
	}

}
