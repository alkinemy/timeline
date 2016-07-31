package com.lezhin.timeline.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimelineMember {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TimelineMember.class);
		springApplication.run(args);
	}

}
