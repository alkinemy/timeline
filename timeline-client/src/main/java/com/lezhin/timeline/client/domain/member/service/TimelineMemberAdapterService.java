package com.lezhin.timeline.client.domain.member.service;

import com.lezhin.timeline.client.config.TimelineMemberRestProperties;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserInsertForm;
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
	private TimelineMemberRestProperties timelineMemberRestProperties;

	public TimelineUserDto getUser(String loginId) {
		String url = new StringBuilder().append(timelineMemberRestProperties.getBaseUrl()).append("/users/{loginId}").toString();
		return timelineRetryTemplate.execute(context -> timelineRestTemplate.getForObject(url, TimelineUserDto.class, loginId));
	}

	public void registerUser(TimelineUserInsertForm insertForm) {
		String url = new StringBuilder().append(timelineMemberRestProperties.getBaseUrl()).append("/users").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, insertForm, Void.class));
	}

	//		agentRetryTemplate.execute(context -> agentRestTemplate.postForEntity(agentProperties.getCallbackDeliverUrl(), response, Void.class));

}
