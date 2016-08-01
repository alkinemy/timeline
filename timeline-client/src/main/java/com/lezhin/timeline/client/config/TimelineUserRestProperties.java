package com.lezhin.timeline.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "timeline.rest.user")
public class TimelineUserRestProperties {

	private String baseUrl;

}
