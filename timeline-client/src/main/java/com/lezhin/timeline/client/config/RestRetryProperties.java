package com.lezhin.timeline.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "timeline.rest.retry")
public class RestRetryProperties {

	private int maxAttempts = 3;
	private long initialInterval = 3 * 100L;
	private long maxInterval = 1000L;

}
