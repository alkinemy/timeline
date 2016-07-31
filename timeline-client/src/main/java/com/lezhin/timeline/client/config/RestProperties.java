package com.lezhin.timeline.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "timeline.rest")
public class RestProperties {

	private int connectTimeout = 3 * 1000;
	private int connectionRequestTimeout = 3 * 1000;
	private int readTimeout = 10 * 1000;

	private int maxAttempts = 3;
	private long initialInterval = 3 * 100L;
	private long maxInterval = 1000L;

}
