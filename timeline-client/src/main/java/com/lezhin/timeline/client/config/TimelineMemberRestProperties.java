package com.lezhin.timeline.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "timeline.rest.member")
public class TimelineMemberRestProperties {

	private int connectTimeout = 3 * 1000;
	private int connectionRequestTimeout = 3 * 1000;
	private int readTimeout = 10 * 1000;

	private String username;
	private String password;

	private String baseUrl;

}
