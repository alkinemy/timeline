package com.lezhin.timeline.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimelineServer {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TimelineServer.class);
		springApplication.run(args);
	}

}
