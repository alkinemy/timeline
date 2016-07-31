package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimelineMessageAdapterService {

	@Autowired
	private RestTemplate timelineRestTemplate;

	@Autowired
	private RetryTemplate timelineRetryTemplate;

	@Autowired
	private TimelineServerRestProperties timelineServerRestProperties;
	//		agentRetryTemplate.execute(context -> agentRestTemplate.postForEntity(agentProperties.getCallbackDeliverUrl(), response, Void.class));

}
