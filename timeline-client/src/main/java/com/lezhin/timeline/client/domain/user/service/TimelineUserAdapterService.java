package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.config.TimelineUserRestProperties;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TimelineUserAdapterService {

	@Autowired
	private RestTemplate timelineRestTemplate;

	@Autowired
	private RetryTemplate timelineRetryTemplate;

	@Autowired
	private TimelineUserRestProperties timelineUserRestProperties;

	public TimelineUserDto getUser(String loginId) {
		String url = new StringBuilder().append(timelineUserRestProperties.getBaseUrl()).append("/users/{loginId}").toString();
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return timelineRetryTemplate.execute(context -> timelineRestTemplate.getForObject(url, TimelineUserDto.class, params));
	}

	public void registerUser(TimelineUserInsertForm insertForm) {
		String url = new StringBuilder().append(timelineUserRestProperties.getBaseUrl()).append("/users").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, insertForm, Void.class));
	}

	//		agentRetryTemplate.execute(context -> agentRestTemplate.postForEntity(agentProperties.getCallbackDeliverUrl(), response, Void.class));

}
