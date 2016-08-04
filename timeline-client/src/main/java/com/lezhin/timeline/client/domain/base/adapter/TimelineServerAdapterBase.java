package com.lezhin.timeline.client.domain.base.adapter;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public abstract class TimelineServerAdapterBase extends AdapterServiceBase {

	@Autowired
	private TimelineServerRestProperties properties;

	@Getter
	@Autowired
	@Qualifier("timelineServerRestTemplate")
	private RestTemplate restTemplate;

	@Override
	protected String getBaseUrl() {
		return properties.getBaseUrl();
	}

}
