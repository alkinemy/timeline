package com.lezhin.timeline.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class EventBusConfig {

	@Bean
	public Environment eventEnvironment() {
		return Environment.initializeIfEmpty().assignErrorJournal();
	}

	@Bean
	public EventBus eventBus() {
		return EventBus.create(eventEnvironment(), Environment.THREAD_POOL);
	}

}
