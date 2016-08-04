package com.lezhin.timeline.client.domain.base.rest;

import com.lezhin.timeline.client.config.TimelineMemberRestProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public abstract class TimelineMemberAdapterBase extends AdapterServiceBase {

	@Autowired
	private TimelineMemberRestProperties properties;

	@Getter
	@Autowired
	@Qualifier("timelineMemberRestTemplate")
	private RestTemplate restTemplate;

	@Override
	protected String getBaseUrl() {
		return properties.getBaseUrl();
	}

}
