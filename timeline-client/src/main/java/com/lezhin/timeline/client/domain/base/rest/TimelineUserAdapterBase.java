package com.lezhin.timeline.client.domain.base.rest;

import com.lezhin.timeline.client.config.TimelineUserRestProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public abstract class TimelineUserAdapterBase extends AdapterServiceBase {

	@Autowired
	private TimelineUserRestProperties properties;

	@Getter
	@Autowired
	@Qualifier("timelineMemberRestTemplate")
	private RestTemplate restTemplate;

	@Override
	protected String getBaseUrl() {
		return properties.getBaseUrl();
	}

}
