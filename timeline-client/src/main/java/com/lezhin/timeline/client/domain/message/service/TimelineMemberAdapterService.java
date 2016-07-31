package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimelineMemberAdapterService {

	@Autowired
	private RestTemplate timelineRestTemplate;

	@Autowired
	private RetryTemplate timelineRetryTemplate;

	@Autowired
	private TimelineServerRestProperties timelineServerRestProperties;

	public TimelineUserDto getUser(String loginId) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/{loginId}").toString();
		return timelineRetryTemplate.execute(context -> timelineRestTemplate.getForObject(url, TimelineUserDto.class, loginId));
	}

	//		agentRetryTemplate.execute(context -> agentRestTemplate.postForEntity(agentProperties.getCallbackDeliverUrl(), response, Void.class));

}
