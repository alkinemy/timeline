package com.lezhin.timeline.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "timeline.rest.server")
public class TimelineServerRestProperties {

	private String baseUrl;

}
