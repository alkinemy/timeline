package com.lezhin.timeline.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private MessageSource messageSource;

	@Bean
	public IDialect java8TimeDialect() {
		return  new Java8TimeDialect();
	}

}
